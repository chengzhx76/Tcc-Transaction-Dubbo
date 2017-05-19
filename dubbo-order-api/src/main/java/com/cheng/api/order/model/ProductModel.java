package com.cheng.api.order.model;

import java.io.Serializable;

/**
 * Desc:
 * Author: 光灿
 * Date: 2017/5/14
 */
public class ProductModel implements Serializable {
    private static final long serialVersionUID = -168513476569370158L;
    private int productId;
    private int productNum;

    public ProductModel(int productId, int productNum) {
        this.productId = productId;
        this.productNum = productNum;
    }

    public int getProductId() {
        return productId;
    }

    public ProductModel setProductId(int productId) {
        this.productId = productId;
        return this;
    }

    public int getProductNum() {
        return productNum;
    }

    public ProductModel setProductNum(int productNum) {
        this.productNum = productNum;
        return this;
    }
}
