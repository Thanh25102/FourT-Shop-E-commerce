package com.buimanhthanh.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buimanhthanh.dao.ProductDao;
import com.buimanhthanh.dto.PriceRange;
import com.buimanhthanh.dto.ProductDTO;
import com.buimanhthanh.entity.Category;
import com.buimanhthanh.entity.Discount;
import com.buimanhthanh.entity.Product;
import com.buimanhthanh.enumration.SortType;
import com.buimanhthanh.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	@Override
	@Transactional
	public Optional<ProductDTO> getProductById(Integer id) {
		return productDao.getProductById(id);
	}

	@Override
	@Transactional
	public Optional<List<ProductDTO>> getAllProduct() {
		return productDao.getAllProduct();
	}

	@Override
	@Transactional
	public Optional<List<ProductDTO>> getAllProduct(int page, int limit) {
		return productDao.getAllProduct(page, limit);
	}

	@Override
	@Transactional
	public Boolean saveOrUpdateProduct(ProductDTO productDTO) {
		Product product = new Product(productDTO.getId(), productDTO.getName(), productDTO.getPrice(),
				productDTO.getDescription(), productDTO.getThumbnail(), productDTO.getRepresent(), null, null, null);

		if (productDTO.getCategoryId() != null) {
			Category category = new Category();
			category.setId(productDTO.getCategoryId());
			product.setCategoryByCategoryId(category);
		}
		if (productDTO.getDiscountId() != null) {
			Discount discount = new Discount();
			discount.setId(productDTO.getDiscountId());
			product.setDiscountByDiscountId(discount);
		}

		return productDao.saveOrUpdateProduct(product);
	}

	@Override
	@Transactional
	public void deleteProduct(Integer id) {
		productDao.deleteProduct(id);
	}

	@Override
	@Transactional
	public void deleteProduct(List<Integer> ids) {
		productDao.deleteProduct(ids);
	}

	@Override
	@Transactional
	public Optional<List<ProductDTO>> getAllProduct(int page, int limit, int categoryId, String orderBy,
			SortType sortType, PriceRange priceRange) {
		return productDao.getAllProduct(page, limit, categoryId, orderBy, sortType, priceRange);
	}

	@Override
	@Transactional
	public Long getCountProductFormCategory(Integer id) {
		return productDao.getCountProductFormCategory(id);
	}

	@Override
	@Transactional
	public Long getCountProductFormCategory() {
		return productDao.getCountProductFormCategory();
	}

}
