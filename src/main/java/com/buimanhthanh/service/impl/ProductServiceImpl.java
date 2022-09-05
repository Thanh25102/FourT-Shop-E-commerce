package com.buimanhthanh.service.impl;

import com.buimanhthanh.dao.ProductDao;
import com.buimanhthanh.entity.Product;
import com.buimanhthanh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    @Transactional
    public Optional<Product> getProductById(Integer id) {
        return productDao.getProductById(id);
    }

    @Override
    @Transactional
    public Optional<List<Product>> getAllProduct() {
        return productDao.getAllProduct();
    }

    @Override
    @Transactional
    public Boolean saveOrUpdateProduct(Product product) {
        return productDao.saveOrUpdateProduct(product);
    }

    @Override
    @Transactional
    public void deleteProduct(Integer id) {
        productDao.deleteProduct(id);
    }

    @Override
    @Transactional
    public void deleteProduct(List<Integer> ids) {
        productDao.deleteProduct(ids);
    }
}
