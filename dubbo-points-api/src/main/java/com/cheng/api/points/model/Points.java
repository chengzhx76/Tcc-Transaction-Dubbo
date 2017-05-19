package com.cheng.api.points.model;

import java.io.Serializable;

/**
 * Desc: 积分
 * Author: hp
 * Date: 2017/5/12
 */
public class Points  implements Serializable {

    private static final long serialVersionUID = 1356510030920794430L;
    private int pointsId;
    private int userId;
    private int balance;

    public int getPointsId() {
        return pointsId;
    }

    public void setPointsId(int pointsId) {
        this.pointsId = pointsId;
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

    public void transferPoints(int points) {
        balance = balance - points;
        if(balance < 0) {
            throw new RuntimeException("积分不够");
        }
    }
}
