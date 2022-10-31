package com.buimanhthanh.dao;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.dto.ProductDetailDTO;
import com.buimanhthanh.entity.ProductDetail;

public interface ProductDetailDao {
    Optional<ProductDetailDTO> getProductDetailById(Integer id);

    Optional<List<ProductDetailDTO>> getAllProductDetail();

    Optional<List<ProductDetailDTO>> getProductDetailByProductId(Integer id);
    Boolean saveOrUpdateProductDetail(ProductDetail productDetail);

    void deleteProductDetail(Integer id);

    void deleteProductDetail(List<Integer> ids);
}
