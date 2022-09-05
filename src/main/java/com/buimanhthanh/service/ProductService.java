package com.buimanhthanh.service;

import com.buimanhthanh.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> getProductById(Integer id);

    Optional<List<Product>> getAllProduct();

    Boolean saveOrUpdateProduct(Product product);

    void deleteProduct(Integer id);

    void deleteProduct(List<Integer> ids);
}
