package com.cheng.api.account.model;

import java.io.Serializable;

/**
 * Desc: 账户交易记录
 * Author: hp
 * Date: 2017/5/12
 */
public class AccountRecord  implements Serializable {

    private static final long serialVersionUID = 3671391405806364201L;
    private int id;
    private int accountId;
    private int orderNo;
    private int amount;
    private String state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
