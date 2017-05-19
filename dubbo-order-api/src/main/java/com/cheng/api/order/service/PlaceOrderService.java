package com.cheng.api.order.service;

import com.cheng.api.order.model.ProductModel;

import java.util.List;

/**
 * Desc: 订单
 * Author: 光灿
 * Date: 2017/5/13
 */
public interface PlaceOrderService {

    /**
     * 下单
     * @param payerUserId
     * @param products
     * @param pointsAmount
     */
    void placeOrder(int payerUserId, List<ProductModel> products, int pointsAmount);

}
