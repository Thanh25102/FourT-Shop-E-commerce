package com.buimanhthanh.service.impl;

import com.buimanhthanh.dao.CategoryDao;
import com.buimanhthanh.entity.Category;
import com.buimanhthanh.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    @Transactional
    public Optional<Category> getCategoryById(Integer id) {
        return categoryDao.getCategoryById(id);
    }

    @Override
    @Transactional
    public Optional<List<Category>> getAllCategory() {
        return categoryDao.getAllCategory();
    }

    @Override
    @Transactional
    public Boolean saveOrUpdateCategory(Category category) {
        return categoryDao.saveOrUpdateCategory(category);
    }

    @Override
    @Transactional
    public void deleteCategory(Integer id) {
        categoryDao.deleteCategory(id);
    }

    @Override
    @Transactional
    public void deleteCategory(List<Integer> ids) {
        categoryDao.deleteCategory(ids);

    }
}
