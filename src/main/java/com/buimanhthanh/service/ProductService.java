package com.buimanhthanh.service;

import com.buimanhthanh.dto.ProductDTO;
import com.buimanhthanh.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<ProductDTO> getProductById(Integer id);

    Optional<List<ProductDTO>> getAllProduct();

    Boolean saveOrUpdateProduct(ProductDTO productDTO);

    void deleteProduct(Integer id);

    void deleteProduct(List<Integer> ids);
}
