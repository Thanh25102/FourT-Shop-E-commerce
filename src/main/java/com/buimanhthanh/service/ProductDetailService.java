package com.buimanhthanh.service;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.dto.ProductDetailDTO;

public interface ProductDetailService {
    Optional<ProductDetailDTO> getProductDetailById(Integer id);

    Optional<List<ProductDetailDTO>> getAllProductDetail();

    Optional<List<ProductDetailDTO>> getProductDetailByProductId(Integer id);

    Boolean saveOrUpdateProductDetail(ProductDetailDTO productDetailDTO);

    void deleteProductDetail(Integer ProductDetail);

    void deleteProductDetailt(List<Integer> ids);
}
