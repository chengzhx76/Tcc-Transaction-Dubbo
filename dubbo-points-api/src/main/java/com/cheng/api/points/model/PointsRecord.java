package com.cheng.api.points.model;

import java.io.Serializable;

/**
 * Desc: 积分记录
 * Author: hp
 * Date: 2017/5/12
 */
public class PointsRecord  implements Serializable {

    private static final long serialVersionUID = 3970842281921074400L;
    private int id;
    private int pointsId;
    private int orderNo;
    private int cost;
    private String state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPointsId() {
        return pointsId;
    }

    public void setPointsId(int pointsId) {
        this.pointsId = pointsId;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
