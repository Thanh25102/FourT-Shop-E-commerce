package com.buimanhthanh.service.impl;

import com.buimanhthanh.dao.CategoryDao;
import com.buimanhthanh.dto.CategoryDTO;
import com.buimanhthanh.dto.CategoryRangeDTO;
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
    public Optional<CategoryDTO> getCategoryById(Integer id) {
        return categoryDao.getCategoryById(id);
    }

    @Override
    @Transactional
    public Optional<List<CategoryDTO>> getAllCategory() {
        return categoryDao.getAllCategory();
    }

    @Override
    @Transactional
    public Boolean saveOrUpdateCategory(CategoryDTO categoryDTO) {
    	Category category = new Category(categoryDTO.getId(),categoryDTO.getName(),categoryDTO.getCode(),categoryDTO.getThumbnail(),categoryDTO.getDescription(),categoryDTO.getLogo(),null);
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

	@Override
	@Transactional
	public Optional<List<CategoryRangeDTO>> getCategoryRange() {
		return categoryDao.getCategoryRange();
	}
}
