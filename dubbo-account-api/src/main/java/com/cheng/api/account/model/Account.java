package com.cheng.api.account.model;

import java.io.Serializable;

/**
 * Desc: 帐户
 * Author: hp
 * Date: 2017/5/12
 */
public class Account implements Serializable {
    private static final long serialVersionUID = -6942959859038257567L;
    private int accountId;
    private int userId;
    private int balance;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void transferAmount(int amount) {
        balance = balance - amount;
        if(balance < 0) {
            throw new RuntimeException("余额不够");
        }
    }
}
