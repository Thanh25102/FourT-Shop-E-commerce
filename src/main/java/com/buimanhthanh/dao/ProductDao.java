package com.buimanhthanh.dao;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.dto.PriceRange;
import com.buimanhthanh.dto.ProductDTO;
import com.buimanhthanh.entity.Product;
import com.buimanhthanh.enumration.SortType;

public interface ProductDao {
	Optional<ProductDTO> getProductById(Integer id);

	Optional<List<ProductDTO>> getAllProduct();

	Optional<List<ProductDTO>> getAllProduct(int page, int limit);

	Optional<List<ProductDTO>> getAllProduct(int page, int limit, int categoryId, String orderBy,
			SortType sortType, PriceRange priceRange);

	Long getCountProductFormCategory(Integer id);

	Long getCountProductFormCategory();
	
	Boolean saveOrUpdateProduct(Product product);

	void deleteProduct(Integer id);

	void deleteProduct(List<Integer> ids);
}
