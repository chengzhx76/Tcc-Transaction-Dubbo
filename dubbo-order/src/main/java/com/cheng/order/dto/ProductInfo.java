package com.cheng.order.dto;

/**
 * Desc:
 * Author: 光灿
 * Date: 2017/5/14
 */
public class ProductInfo {
    private int productId;
    private int productNum;
    private int unitPrice;

    public ProductInfo(int productId, int productNum, int unitPrice) {
        this.productId = productId;
        this.productNum = productNum;
        this.unitPrice = unitPrice;
    }

    public int getProductId() {
        return productId;
    }

    public ProductInfo setProductId(int productId) {
        this.productId = productId;
        return this;
    }

    public int getProductNum() {
        return productNum;
    }

    public ProductInfo setProductNum(int productNum) {
        this.productNum = productNum;
        return this;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public ProductInfo setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }
}
