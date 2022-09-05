package com.buimanhthanh.dao;

import com.buimanhthanh.entity.Discount;
import com.buimanhthanh.entity.Size;

import java.util.List;
import java.util.Optional;

public interface DiscountDao {
    Optional<Discount> getDiscountById(Integer id);

    Optional<List<Discount>> getAllDiscount();

    Boolean saveOrUpdateDiscount(Discount discount);

    void deleteDiscount(Integer id);

    void deleteDiscount(List<Integer> ids);
}
