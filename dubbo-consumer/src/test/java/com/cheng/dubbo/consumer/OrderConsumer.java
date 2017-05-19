package com.cheng.dubbo.consumer;

import com.cheng.api.order.model.ProductModel;
import com.cheng.api.order.service.PlaceOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 * Author: 光灿
 * Date: 2017/5/14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class OrderConsumer {
    @Resource
    private PlaceOrderService placeOrderService;

    @Test
    public void placeOrder() {
        List<ProductModel> models = new ArrayList<>();
        models.add(new ProductModel(1, 1));
        placeOrderService.placeOrder(1, models, 10);
    }
}
