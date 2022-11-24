package com.buimanhthanh.service;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.dto.DiscountCodeDTO;

public interface DiscountCodeService {
    Optional<DiscountCodeDTO> getDiscountCodeById(Integer id);

    Optional<List<DiscountCodeDTO>> getAllDiscountCode();

    Optional<DiscountCodeDTO> getDiscountCodeByCode(String code);
    
    Boolean saveOrUpdateDiscountCode(DiscountCodeDTO discountCodeDTO);

    void deleteDiscountCode(Integer id);

    void deleteDiscountCode(List<Integer> ids);
}
