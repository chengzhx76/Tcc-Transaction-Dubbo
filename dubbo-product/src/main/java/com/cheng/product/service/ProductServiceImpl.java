package com.cheng.product.service;

import com.cheng.api.product.model.Product;
import com.cheng.api.product.service.ProductService;
import com.cheng.product.dao.ProductDaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Desc: 商品
 * Author: 光灿
 * Date: 2017/5/13
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDaoMapper productDao;

    @Override
    public List<Product> getProducts() {
        return productDao.loadAll();
    }

    @Override
    public Product getProductById(int productId) {
        Product product = new Product();
        product.setProductId(productId);
        return productDao.load(product);
    }

    @Override
    public void updateProduct(Product product) {
        productDao.update(product);
    }
}
