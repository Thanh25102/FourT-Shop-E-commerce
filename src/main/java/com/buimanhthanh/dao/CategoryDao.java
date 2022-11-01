package com.buimanhthanh.dao;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.dto.CategoryDTO;
import com.buimanhthanh.dto.CategoryRangeDTO;
import com.buimanhthanh.entity.Category;

public interface CategoryDao {
    Optional<CategoryDTO> getCategoryById(Integer id);

    Optional<List<CategoryDTO>> getAllCategory();
    
    Optional<List<CategoryRangeDTO>> getCategoryRange();

    Boolean saveOrUpdateCategory(Category category);

    void deleteCategory(Integer id);

    void deleteCategory(List<Integer> ids);
}
