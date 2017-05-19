package com.cheng.order.service;

import com.cheng.order.model.Orders;
import org.mengyun.tcctransaction.Compensable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Desc:
 * Author: 光灿
 * Date: 2017/5/14
 */
@Service("paymentService")
public class PaymentService {

    Logger log = LoggerFactory.getLogger(getClass());

    //@Autowired
    //private OrderService orderService;
    //@Autowired
    //private AccountService accountService;
    //@Autowired
    //private PointsService pointsService;

    @Compensable(confirmMethod = "confirmMakePayment", cancelMethod = "cancelMakePayment")
    public void makePayment(Orders order, int pointsPayAmount, int accountPayAmount) {

        log.info("---> 支付Start");

        /*order.pay(pointsPayAmount, accountPayAmount);
        orderService.updateOrder(order);

        // 现金记录
        String accountResult = accountService.saveRecord(order.getUserId(), order.getOrderNo(), order.getCastAmount());

        log.info("扣除现金" + accountResult);

        // 积分记录
        String pointsResult = pointsService.saveRecord(order.getUserId(), order.getOrderNo(), order.getCostPoints());

        log.info("扣除积分" + pointsResult);

        order.confirm();
        orderService.updateOrder(order);*/

        throw new RuntimeException("支付失败");

//        log.info("---> 支付End");

    }

    /**
     * 支付成功
     */
    public void confirmMakePayment(Orders order, int pointsPayAmount, int accountPayAmount) {
        log.info("---> 支付确认");
    }

    /**
     * 取消支付
     */
    public void cancelMakePayment(Orders order, int pointsPayAmount, int accountPayAmount) {
        log.info("---> 支付取消");
    }

}
