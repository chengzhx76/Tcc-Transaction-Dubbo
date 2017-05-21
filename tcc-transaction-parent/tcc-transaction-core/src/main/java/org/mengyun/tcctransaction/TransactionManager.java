package org.mengyun.tcctransaction;

import org.apache.log4j.Logger;
import org.mengyun.tcctransaction.api.TransactionContext;
import org.mengyun.tcctransaction.api.TransactionStatus;
import org.mengyun.tcctransaction.api.TransactionXid;
import org.mengyun.tcctransaction.common.TransactionType;
import org.mengyun.tcctransaction.support.TransactionConfigurator;

/**
 * 事务管理器.
 * Created by changmingxie on 10/26/15.
 */
public class TransactionManager {

    static final Logger LOG = Logger.getLogger(TransactionManager.class.getSimpleName());

    /**
	 * 事务配置器
	 */
    private TransactionConfigurator transactionConfigurator;

    public TransactionManager(TransactionConfigurator transactionConfigurator) {
        this.transactionConfigurator = transactionConfigurator;
    }

    /**
     * 定义当前线程的事务局部变量.
     */
    private ThreadLocal<Transaction> threadLocalTransaction = new ThreadLocal<Transaction>();

    /**
     * 事务开始（创建事务日志记录，并将该事务日志记录存入当前线程的事务局部变量中）
     */
    public void begin() {
    	LOG.debug("-->事务开始");
        // 创建事务，事务类型为根事务ROOT
        Transaction transaction = new Transaction(TransactionType.ROOT);
        LOG.debug("-->事务类型:" + transaction.getTransactionType().toString() + ", 事务状态:" + transaction.getStatus().toString());
        TransactionRepository transactionRepository = transactionConfigurator.getTransactionRepository();
        // 创建事务记录,写入事务日志库
        transactionRepository.create(transaction);
        threadLocalTransaction.set(transaction);   // 将该事务日志记录存入当前线程的事务局部变量中
    }

    /**
     * 基于全局事务ID扩展创建新的分支事务，并存于当前线程的事务局部变量中.
     * @param transactionContext
     */
    public void propagationNewBegin(TransactionContext transactionContext) {

        Transaction transaction = new Transaction(transactionContext);
        LOG.debug("-->扩展创建新的分支事务 TransactionXid：" + TransactionXid.byteArrayToUUID(transaction.getXid().getGlobalTransactionId()).toString()
        		+ "|" + TransactionXid.byteArrayToUUID(transaction.getXid().getBranchQualifier()).toString());
        
        transactionConfigurator.getTransactionRepository().create(transaction);

        threadLocalTransaction.set(transaction);
    }

    /**
     * 找出存在的事务并处理.
     * @param transactionContext
     * @throws NoExistedTransactionException
     */
    public void propagationExistBegin(TransactionContext transactionContext) throws NoExistedTransactionException {
        TransactionRepository transactionRepository = transactionConfigurator.getTransactionRepository();
        Transaction transaction = transactionRepository.findByXid(transactionContext.getXid());

        // 如果找到了事物
        if (transaction != null) {
        	
        	LOG.debug("-->找出存在的事务 TransactionXid：" + TransactionXid.byteArrayToUUID(transaction.getXid().getGlobalTransactionId()).toString()
            		+ "|" + TransactionXid.byteArrayToUUID(transaction.getXid().getBranchQualifier()).toString());
            // 更改事务状态为transactionContext中的状态
            transaction.changeStatus(TransactionStatus.valueOf(transactionContext.getStatus()));
            threadLocalTransaction.set(transaction);
        } else {
            throw new NoExistedTransactionException();
        }
    }

    /**
     * 提交.
     */
    public void commit() {
    	LOG.debug("-->提交");
        // 获取本地线程上事务队列中的时间最久的事务
        Transaction transaction = getCurrentTransaction();

        // 更改事务状态为CONFIRMING
        transaction.changeStatus(TransactionStatus.CONFIRMING);
        LOG.debug("-->更新事务状态为 CONFIRMING");
        // 更新事务持久化
        transactionConfigurator.getTransactionRepository().update(transaction);

        try {
        	LOG.info("-->事务开始提交");
            // 调用事务的commit
            transaction.commit();
            // 如果上面的commit没有抛出任何异常就说明事务成功，就从事务日志中删除这个事务
            transactionConfigurator.getTransactionRepository().delete(transaction);
        } catch (Throwable commitException) {
            // 事务commit过程抛出了异常
            LOG.error("compensable transaction confirm failed.", commitException);
            // 转为抛出ConfirmingException异常，这样会导致事务在事务日志中不被删除，recovery会去处理长时间没有被删除的事务
            throw new ConfirmingException(commitException);
        }
    }

    /**
     * 获取当前事务.
     * @return
     */
    public Transaction getCurrentTransaction() {
        return threadLocalTransaction.get();
    }

    /**
     * 回滚事务.
     */
    public void rollback() {
        // 回滚事务
        Transaction transaction = getCurrentTransaction();
        // 更改事务状态为CANCELLING
        transaction.changeStatus(TransactionStatus.CANCELLING);
        // 更新事务持久化日志
        transactionConfigurator.getTransactionRepository().update(transaction);
        
        try {
        	LOG.info("-->开始回滚事务");
            // 调用事务的rollback
            transaction.rollback();
            // 没有异常，就从事务日志中删除这个事务
            transactionConfigurator.getTransactionRepository().delete(transaction);
        } catch (Throwable rollbackException) {
            LOG.error("compensable transaction rollback failed.", rollbackException);
            // 否则事务异常，抛出CancellingException
            throw new CancellingException(rollbackException);
        }
    }
}
