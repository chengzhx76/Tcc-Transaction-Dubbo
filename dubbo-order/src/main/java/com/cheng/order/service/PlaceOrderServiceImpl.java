package com.cheng.order.service;

import com.cheng.api.order.model.ProductModel;
import com.cheng.api.order.service.PlaceOrderService;
import com.cheng.order.dto.ProductInfo;
import com.cheng.order.model.Orders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc: 订单操作
 * Author: 光灿
 * Date: 2017/5/14
 */
@Service("placeOrderService")
public class PlaceOrderServiceImpl implements PlaceOrderService {

    Logger log = LoggerFactory.getLogger(getClass());

    //@Autowired
    //private ProductService productService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private PaymentService paymentService;

    @Override
    public void placeOrder(int userId, List<ProductModel> productModels, int pointsAmount) {
        // TODO 检查库存

        log.info("--->创建订单");

        // 创建订单
        List<ProductInfo> infos = new ArrayList<>();
        //for (ProductModel productModel : productModels) {
        //    Product product = productService.getProductById(productModel.getProductId());
        //    infos.add(new ProductInfo(productModel.getProductId(), productModel.getProductNum(), product.getPrice()));
        //}
        Orders order = orderService.createOrder(userId, infos);

        // 付款
        paymentService.makePayment(order, pointsAmount, order.getTotalAmount()-pointsAmount);

        log.info("--->创建订单End");
    }
}
