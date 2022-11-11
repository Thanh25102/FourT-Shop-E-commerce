package com.buimanhthanh.service;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.dto.PriceRange;
import com.buimanhthanh.dto.ProductDTO;
import com.buimanhthanh.enumration.SortType;

public interface ProductService {
	Optional<ProductDTO> getProductById(Integer id);

	Optional<List<ProductDTO>> getAllProduct();

	Optional<List<ProductDTO>> getAllProduct(int page, int limit);

	Optional<List<ProductDTO>> getAllProduct(int page, int limit, int categoryId, String orderBy, SortType sortType,
			PriceRange priceRange);
	
	Optional<List<ProductDTO>> getLatestProducts(int record);

	Long getCountAllProduct(Integer page, Integer limit, Integer categoryId, String orderBy, SortType sortType,
			PriceRange priceRange);

	Long getCountProductFormCategory(Integer id);

	Long getCountProductFormCategory();

	Boolean saveOrUpdateProduct(ProductDTO productDTO);

	void deleteProduct(Integer id);

	void deleteProduct(List<Integer> ids);
}
