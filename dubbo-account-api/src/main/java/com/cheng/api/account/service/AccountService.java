package com.cheng.api.account.service;

import com.cheng.api.account.model.Account;
import com.cheng.api.account.model.AccountRecord;

/**
 * Desc: 账户
 * Author: 光灿
 * Date: 2017/5/12
 */
public interface AccountService {
    /**
     * 根据用户ID获取账户信息
     * @param userId
     * @return
     */
    Account getAccountByUserId(int userId);

    /**
     * 更新账户信息
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 保存账户记录信息
     * @param record
     */
    void saveAccountRecord(AccountRecord record);

    /**
     * 购买商品
     * @param userId
     * @param orderNo
     * @param amount
     */
    String saveRecord(int userId, int orderNo, int amount);

    /**
     *
     * @param userId
     * @param amount
     */
    void saveLocalTxTest(int userId, int amount);

}
