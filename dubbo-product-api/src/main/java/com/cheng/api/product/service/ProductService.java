package com.cheng.api.product.service;

import com.cheng.api.product.model.Product;

import java.util.List;

/**
 * Desc: 商品
 * Author: 光灿
 * Date: 2017/5/13
 */
public interface ProductService {
    /**
     * 获取所有的商品
     * @return
     */
    List<Product> getProducts();

    /**
     * 获取商品
     * @return
     */
    Product getProductById(int productId);

    /**
     * 更新商品
     * @param product
     * @return
     */
    void updateProduct(Product product);

}
