package com.cheng.api.product.model;

import java.io.Serializable;

/**
 * Desc: 商品
 * Author: hp
 * Date: 2017/5/12
 */
public class Product  implements Serializable {

    private static final long serialVersionUID = 7862946415900695423L;
    private int productId;
    private String productName;
    private int count;
    private int price;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
