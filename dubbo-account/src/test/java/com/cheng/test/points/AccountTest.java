package com.cheng.test.points;

import com.cheng.api.account.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Desc:
 * Author: 光灿
 * Date: 2017/5/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-context.xml"})
public class AccountTest {

    @Resource
    private AccountService accountService;

    @Test
    public void testLocalTx() {
        accountService.saveLocalTxTest(1, 10);
    }

}
