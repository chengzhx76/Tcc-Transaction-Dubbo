package com.cheng.order.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc: 订单
 * Author: hp
 * Date: 2017/5/12
 */
public class Orders implements Serializable {

    private static final long serialVersionUID = -8203858796073490250L;
    private int orderNo;
    private int userId;
    private int castAmount;
    private int costPoints;
    private String state = "DRAFT";

    private List<OrderDetail> details = new ArrayList<>();

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCastAmount() {
        return castAmount;
    }

    public void setCastAmount(int castAmount) {
        this.castAmount = castAmount;
    }

    public int getCostPoints() {
        return costPoints;
    }

    public void setCostPoints(int costPoints) {
        this.costPoints = costPoints;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<OrderDetail> getDetails() {
        return details;
    }

    public Orders setDetails(List<OrderDetail> details) {
        this.details = details;
        return this;
    }

    public void pay(int pointsPayAmount, int accountPayAmount) {
        this.costPoints = pointsPayAmount;
        this.castAmount = accountPayAmount;
        this.state = "PAYING";
    }

    public int getTotalAmount() {
        int totalAmount = 0;
        for (OrderDetail detail : details) {
            totalAmount+=detail.getNumber()*detail.getUnitPrice();
        }
        return totalAmount;
    }

    public void confirm() {
        this.state = "CONFIRMED";
    }

    public void cancelPayment() {
        this.state = "PAY_FAILED";
    }
}
