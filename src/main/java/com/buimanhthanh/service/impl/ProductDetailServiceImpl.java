package com.buimanhthanh.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buimanhthanh.dao.ProductDetailDao;
import com.buimanhthanh.entity.ProductDetail;
import com.buimanhthanh.service.ProductDetailService;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {

	@Autowired
	private ProductDetailDao productDetailDao;

	@Override
	@Transactional
	public Optional<ProductDetail> getProductDetailById(Integer id) {
		// TODO Auto-generated method stub
		return productDetailDao.getProductDetailById(id);
	}

	@Override
	@Transactional
	public Optional<List<ProductDetail>> getAllProductDetail() {
		// TODO Auto-generated method stub
		return productDetailDao.getAllProductDetail();
	}

	@Override
	@Transactional
	public Boolean saveOrUpdateProductDetail(ProductDetail productDetail) {
		// TODO Auto-generated method stub
		return productDetailDao.saveOrUpdateProductDetail(productDetail);
	}

	@Override
	@Transactional
	public void deleteProductDetail(Integer productDetailId) {
		// TODO Auto-generated method stub
		productDetailDao.deleteProductDetail(productDetailId);
	}

	@Override
	@Transactional
	public void deleteProductDetailt(List<Integer> ids) {
		productDetailDao.deleteProductDetail(ids);
	}

}
