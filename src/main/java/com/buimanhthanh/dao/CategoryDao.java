package com.buimanhthanh.dao;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.entity.Category;

public interface CategoryDao {
    Optional<Category> getCategoryById(Integer id);

    Optional<List<Category>> getAllCategory();

    Boolean saveOrUpdateCategory(Category category);

    void deleteCategory(Integer id);

    void deleteCategory(List<Integer> ids);
}
