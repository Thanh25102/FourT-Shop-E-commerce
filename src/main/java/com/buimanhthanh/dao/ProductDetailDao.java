package com.buimanhthanh.dao;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.entity.ProductDetail;

public interface ProductDetailDao {
    Optional<ProductDetail> getProductDetailById(Integer id);

    Optional<List<ProductDetail>> getAllProductDetail();

    Boolean saveOrUpdateProductDetail(ProductDetail productDetail);

    void deleteProductDetail(Integer id);

    void deleteProductDetail(List<Integer> ids);
}
