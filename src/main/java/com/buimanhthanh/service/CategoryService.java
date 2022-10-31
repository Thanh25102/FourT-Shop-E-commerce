package com.buimanhthanh.service;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.dto.CategoryDTO;

public interface CategoryService {
    Optional<CategoryDTO> getCategoryById(Integer id);

    Optional<List<CategoryDTO>> getAllCategory();

    Boolean saveOrUpdateCategory(CategoryDTO categoryDTO);

    void deleteCategory(Integer id);

    void deleteCategory(List<Integer> ids);
}
