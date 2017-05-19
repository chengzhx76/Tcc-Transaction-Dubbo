package com.cheng.dubbo.consumer;

import com.cheng.api.account.model.Account;
import com.cheng.api.account.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Desc: 消费者
 * Author: Cheng
 * Date: 2016/2/19 0019
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class AccountConsumer {
    @Resource
    private AccountService accountService;

    @Test
    public void test() {
        Account account = accountService.getAccountByUserId(1);
        System.out.println(account);
    }

    @Test
    public void buyProduct() {
        accountService.saveRecord(1, 201732231, 15);
    }

    @Test
    public void testTx() {
        accountService.saveLocalTxTest(1, 10);
    }

}
