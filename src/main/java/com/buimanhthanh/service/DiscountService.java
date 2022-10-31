package com.buimanhthanh.service;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.dto.DiscountDTO;

public interface DiscountService {
    Optional<DiscountDTO> getDiscountById(Integer id);

    Optional<List<DiscountDTO>> getAllDiscount();

    Boolean saveOrUpdateDiscount(DiscountDTO discountDTO);

    void deleteDiscount(Integer id);

    void deleteDiscount(List<Integer> ids);
}
