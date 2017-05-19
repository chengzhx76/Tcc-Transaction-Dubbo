package com.cheng.account.service;

import com.cheng.account.dao.AccountDaoMapper;
import com.cheng.account.dao.AccountRecordDaoMapper;
import com.cheng.api.account.model.Account;
import com.cheng.api.account.model.AccountRecord;
import com.cheng.api.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Desc: 账户
 * Author: 光灿
 * Date: 2017/5/12
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDaoMapper accountDao;
    @Autowired
    private AccountRecordDaoMapper accountRecord;

    @Override
    public Account getAccountByUserId(int userId) {
        Account account = new Account();
        account.setUserId(userId);
        return accountDao.load(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.update(account);
    }

    @Override
    public void saveAccountRecord(AccountRecord record) {
        accountRecord.save(record);
    }

    @Override
    public String saveRecord(int userId, int orderNo, int amount) {
        Account account = getAccountByUserId(userId);
        account.transferAmount(amount);
        updateAccount(account);

        AccountRecord record = new AccountRecord();
        record.setAccountId(account.getAccountId());
        record.setAmount(amount);
        record.setOrderNo(orderNo);
        record.setState("SUCCESS");
        saveAccountRecord(record);
        return "SUCCESS";
    }

    @Override
    public void saveLocalTxTest(int userId, int amount) {
        Account account = getAccountByUserId(userId);
        account.setBalance(account.getBalance() - amount);
        updateAccount(account);

        throw new RuntimeException("本地事务测试");
    }
}
