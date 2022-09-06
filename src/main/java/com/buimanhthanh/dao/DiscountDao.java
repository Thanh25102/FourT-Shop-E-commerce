package com.buimanhthanh.dao;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.entity.Discount;

public interface DiscountDao {
    Optional<Discount> getDiscountById(Integer id);

    Optional<List<Discount>> getAllDiscount();

    Boolean saveOrUpdateDiscount(Discount discount);

    void deleteDiscount(Integer id);

    void deleteDiscount(List<Integer> ids);
}
