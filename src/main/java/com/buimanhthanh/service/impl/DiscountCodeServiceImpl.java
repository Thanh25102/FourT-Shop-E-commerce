package com.buimanhthanh.service.impl;

import com.buimanhthanh.dao.DiscountCodeDao;
import com.buimanhthanh.dto.DiscountCodeDTO;
import com.buimanhthanh.entity.DiscountCode;
import com.buimanhthanh.service.DiscountCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DiscountCodeServiceImpl implements DiscountCodeService {
    @Autowired
    private DiscountCodeDao discountCodeDao;

    @Override
    @Transactional
    public Optional<DiscountCodeDTO> getDiscountCodeById(Integer id) {
        return discountCodeDao.getDiscountCodeById(id);
    }

    
    @Override
    @Transactional
    public Optional<List<DiscountCodeDTO>> getAllDiscountCode() {
        return discountCodeDao.getAllDiscountCode();
    }

    @Override
    @Transactional
    public Boolean saveOrUpdateDiscountCode(DiscountCodeDTO discountCodeDTO) {
    	DiscountCode discountCode = new DiscountCode(discountCodeDTO.getId(),discountCodeDTO.getCode(),discountCodeDTO.getSalePercent(),discountCodeDTO.getSaleMoney(),discountCodeDTO.getStartDay(),discountCodeDTO.getEndDay(),discountCodeDTO.getMaxDiscount(),discountCodeDTO.getDescription(),null);
        return discountCodeDao.saveOrUpdateDiscountCode(discountCode);
    }

    @Override
    @Transactional
    public void deleteDiscountCode(Integer id) {
        discountCodeDao.deleteDiscountCode(id);
    }

    @Override
    @Transactional
    public void deleteDiscountCode(List<Integer> ids) {
        discountCodeDao.deleteDiscountCode(ids);
    }


	@Override
	@Transactional
	public Optional<DiscountCodeDTO> getDiscountCodeByCode(String code) {
		return discountCodeDao.getDiscountCodeByCode(code);
	}
}
