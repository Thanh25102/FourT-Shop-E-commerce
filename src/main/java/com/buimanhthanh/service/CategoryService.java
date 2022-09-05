package com.buimanhthanh.service;

import com.buimanhthanh.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Optional<Category> getCategoryById(Integer id);

    Optional<List<Category>> getAllCategory();

    Boolean saveOrUpdateCategory(Category category);

    void deleteCategory(Integer id);

    void deleteCategory(List<Integer> ids);
}
