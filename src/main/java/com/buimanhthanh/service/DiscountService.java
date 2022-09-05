package com.buimanhthanh.service;

import com.buimanhthanh.entity.Discount;

import java.util.List;
import java.util.Optional;

public interface DiscountService {
    Optional<Discount> getDiscountById(Integer id);

    Optional<List<Discount>> getAllDiscount();

    Boolean saveOrUpdateDiscount(Discount discount);

    void deleteDiscount(Integer id);

    void deleteDiscount(List<Integer> ids);
}
