package com.buimanhthanh.dao;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.entity.DiscountCode;

public interface DiscountCodeDao {
    Optional<DiscountCode> getDiscountCodeById(Integer id);

    Optional<List<DiscountCode>> getAllDiscountCode();

    Boolean saveOrUpdateDiscountCode(DiscountCode discountCode);

    void deleteDiscountCode(Integer id);

    void deleteDiscountCode(List<Integer> ids);
}
