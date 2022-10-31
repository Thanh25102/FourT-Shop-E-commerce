package com.buimanhthanh.service;

import com.buimanhthanh.dto.DiscountCodeDTO;
import com.buimanhthanh.entity.DiscountCode;

import java.util.List;
import java.util.Optional;

public interface DiscountCodeService {
    Optional<DiscountCodeDTO> getDiscountCodeById(Integer id);

    Optional<List<DiscountCodeDTO>> getAllDiscountCode();

    Boolean saveOrUpdateDiscountCode(DiscountCodeDTO discountCodeDTO);

    void deleteDiscountCode(Integer id);

    void deleteDiscountCode(List<Integer> ids);
}
