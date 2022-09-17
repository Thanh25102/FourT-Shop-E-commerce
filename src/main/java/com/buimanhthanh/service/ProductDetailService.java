package com.buimanhthanh.service;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.entity.ProductDetail;

public interface ProductDetailService {
    Optional<ProductDetail> getProductDetailById(Integer id);

    Optional<List<ProductDetail>> getAllProductDetail();

    Boolean saveOrUpdateProductDetail(ProductDetail productDetail);

    void deleteProductDetail(Integer ProductDetail);

    void deleteProductDetailt(List<Integer> ids);
}
