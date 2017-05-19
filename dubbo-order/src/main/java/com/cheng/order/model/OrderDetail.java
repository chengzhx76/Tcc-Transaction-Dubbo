package com.cheng.order.model;

/**
 * Desc: 订单详情
 * Author: hp
 * Date: 2017/5/12
 */
public class OrderDetail {

    private int id;
    private int orderNO;
    private int productId;
    private int number;
    private int unitPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderNO() {
        return orderNO;
    }

    public OrderDetail setOrderNO(int orderNO) {
        this.orderNO = orderNO;
        return this;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }
}
