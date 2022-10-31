package com.buimanhthanh.dao;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.dto.DiscountDTO;
import com.buimanhthanh.entity.Discount;

public interface DiscountDao {
    Optional<DiscountDTO> getDiscountById(Integer id);

    Optional<List<DiscountDTO>> getAllDiscount();

    Boolean saveOrUpdateDiscount(Discount discount);

    void deleteDiscount(Integer id);

    void deleteDiscount(List<Integer> ids);
}
