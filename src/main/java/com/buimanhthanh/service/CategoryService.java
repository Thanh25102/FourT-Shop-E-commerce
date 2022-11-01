package com.buimanhthanh.service;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.dto.CategoryDTO;
import com.buimanhthanh.dto.CategoryRangeDTO;

public interface CategoryService {
    Optional<CategoryDTO> getCategoryById(Integer id);

    Optional<List<CategoryDTO>> getAllCategory();
    
    Optional<List<CategoryRangeDTO>> getCategoryRange();

    Boolean saveOrUpdateCategory(CategoryDTO categoryDTO);

    void deleteCategory(Integer id);

    void deleteCategory(List<Integer> ids);
}
