package com.buimanhthanh.dao;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.dto.DiscountCodeDTO;
import com.buimanhthanh.entity.DiscountCode;

public interface DiscountCodeDao {
    Optional<DiscountCodeDTO> getDiscountCodeById(Integer id);

    Optional<List<DiscountCodeDTO>> getAllDiscountCode();

    Boolean saveOrUpdateDiscountCode(DiscountCode discountCode);

    void deleteDiscountCode(Integer id);

    void deleteDiscountCode(List<Integer> ids);
}
