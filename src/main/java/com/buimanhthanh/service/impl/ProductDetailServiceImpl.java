package com.buimanhthanh.service.impl;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.dto.ProductDetailDTO;
import com.buimanhthanh.entity.Color;
import com.buimanhthanh.entity.Product;
import com.buimanhthanh.entity.Size;
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
	public Optional<ProductDetailDTO> getProductDetailById(Integer id) {
		// TODO Auto-generated method stub
		return productDetailDao.getProductDetailById(id);
	}

	@Override
	@Transactional
	public Optional<List<ProductDetailDTO>> getAllProductDetail() {
		// TODO Auto-generated method stub
		return productDetailDao.getAllProductDetail();
	}

	@Override
	@Transactional
	public Optional<List<ProductDetailDTO>> getProductDetailByProductId(Integer id) {
		return productDetailDao.getProductDetailByProductId(id);
	}

	@Override
	@Transactional
	public Boolean saveOrUpdateProductDetail(ProductDetailDTO productDetailDTO) {
		ProductDetail productDetail = new ProductDetail(productDetailDTO.getId(),productDetailDTO.getQuantity(),productDetailDTO.getDescription(),productDetailDTO.getImage(),null,null,null,null,null);

		if(productDetailDTO.getProductId() != null){
			Product product = new Product();
			product.setId(productDetailDTO.getProductId());
			productDetail.setProductByProductId(product);
		}
		if(productDetailDTO.getSizeId() != null){
			Size size = new Size();
			size.setId(productDetailDTO.getSizeId());
			productDetail.setSizeBySizeId(size);
		}
		if(productDetailDTO.getColorId() != null){
			Color color = new Color();
			color.setId(productDetailDTO.getColorId());
			productDetail.setColorByColorId(color);
		}
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
