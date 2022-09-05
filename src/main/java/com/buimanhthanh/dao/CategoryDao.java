package com.buimanhthanh.dao;

import com.buimanhthanh.entity.Category;
import com.buimanhthanh.entity.Role;

import java.util.List;
import java.util.Optional;

public interface CategoryDao {
    Optional<Category> getCategoryById(Integer id);

    Optional<List<Category>> getAllCategory();

    Boolean saveOrUpdateCategory(Category category);

    void deleteCategory(Integer id);

    void deleteCategory(List<Integer> ids);
}
