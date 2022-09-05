package com.buimanhthanh.service;

import com.buimanhthanh.entity.DiscountCode;

import java.util.List;
import java.util.Optional;

public interface DiscountCodeService {
    Optional<DiscountCode> getDiscountCodeById(Integer id);

    Optional<List<DiscountCode>> getAllDiscountCode();

    Boolean saveOrUpdateDiscountCode(DiscountCode discountCode);

    void deleteDiscountCode(Integer id);

    void deleteDiscountCode(List<Integer> ids);
}
