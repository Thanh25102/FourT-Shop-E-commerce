package com.buimanhthanh.dao;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.entity.Product;

public interface ProductDao {
    Optional<Product> getProductById(Integer id);

    Optional<List<Product>> getAllProduct();

    Boolean saveOrUpdateProduct(Product product);

    void deleteProduct(Integer id);

    void deleteProduct(List<Integer> ids);
}
