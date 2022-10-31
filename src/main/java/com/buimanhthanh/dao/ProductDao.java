package com.buimanhthanh.dao;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.dto.ProductDTO;
import com.buimanhthanh.entity.Product;

public interface ProductDao {
    Optional<ProductDTO> getProductById(Integer id);

    Optional<List<ProductDTO>> getAllProduct();

    Boolean saveOrUpdateProduct(Product product);

    void deleteProduct(Integer id);

    void deleteProduct(List<Integer> ids);
}
