package com.cheng.order.service;

import com.cheng.order.dao.OrdersDaoMapper;
import com.cheng.order.dao.OrderDetailDaoMapper;
import com.cheng.order.dto.ProductInfo;
import com.cheng.order.model.Orders;
import com.cheng.order.model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Desc: 订单
 * Author: 光灿
 * Date: 2017/5/13
 */
@Service("orderService")
public class OrderService {
    @Autowired
    private OrdersDaoMapper ordersDao;
    @Autowired
    private OrderDetailDaoMapper orderDetailDao;

    /**
     * 订单
     * @param userId
     * @return
     */
    public Orders getOrderByUserId(int userId) {
        Orders order = new Orders();
        order.setUserId(userId);
        return ordersDao.load(order);
    }

    /**
     * 保存订单
     * @param order
     */
    public void saveOrder(Orders order) {
        ordersDao.save(order);
    }

    /**
     * 更新订单
     * @param order
     */
    public void updateOrder(Orders order) {
        ordersDao.update(order);
    }

    /**
     * 保存商品详情
     * @param detail
     */
    public void saveOrderDetail(OrderDetail detail) {
        orderDetailDao.save(detail);
    }

    /**
     * 更新订单详情
     * @param detail
     */
    public void updateOrderDetail(OrderDetail detail) {
        orderDetailDao.update(detail);
    }

    /**
     * 购买商品
     * @param payerUserId
     * @param prductInfos
     */
    public Orders createOrder(int payerUserId, List<ProductInfo> prductInfos) {
        int orderNo = new Random().nextInt();

        List<OrderDetail> orderDetails = new ArrayList<>();
        for (ProductInfo info : prductInfos) {
            OrderDetail detail = new OrderDetail();
            detail.setOrderNO(orderNo);
            detail.setProductId(info.getProductId());
            detail.setNumber(info.getProductNum());
            detail.setUnitPrice(info.getUnitPrice());
            orderDetails.add(detail);
            orderDetailDao.save(detail);
        }
        Orders order = new Orders();
        order.setUserId(payerUserId);
        order.setOrderNo(orderNo);
        order.setDetails(orderDetails);
        ordersDao.save(order);

        return order;
    }
}
