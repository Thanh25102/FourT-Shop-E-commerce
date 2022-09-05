package com.buimanhthanh.service.impl;

import com.buimanhthanh.dao.DiscountDao;
import com.buimanhthanh.entity.Discount;
import com.buimanhthanh.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DiscountServiceImpl implements DiscountService {
    @Autowired
    private DiscountDao discountDao;

    @Override
    @Transactional
    public Optional<Discount> getDiscountById(Integer id) {
        return discountDao.getDiscountById(id);
    }

    @Override
    @Transactional
    public Optional<List<Discount>> getAllDiscount() {
        return discountDao.getAllDiscount();
    }

    @Override
    @Transactional
    public Boolean saveOrUpdateDiscount(Discount discount) {
        return discountDao.saveOrUpdateDiscount(discount);
    }

    @Override
    @Transactional
    public void deleteDiscount(Integer id) {
        discountDao.deleteDiscount(id);
    }

    @Override
    @Transactional
    public void deleteDiscount(List<Integer> ids) {
        discountDao.deleteDiscount(ids);
    }
}
