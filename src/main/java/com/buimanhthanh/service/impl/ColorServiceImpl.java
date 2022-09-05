package com.buimanhthanh.service.impl;

import com.buimanhthanh.dao.ColorDao;
import com.buimanhthanh.entity.Color;
import com.buimanhthanh.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ColorServiceImpl implements ColorService {
    @Autowired
    private ColorDao colorDao;

    @Override
    @Transactional
    public Optional<Color> getColorById(Integer id) {
        return colorDao.getColorById(id);
    }

    @Override
    @Transactional
    public Optional<List<Color>> getAllColor() {
        return colorDao.getAllColor();
    }

    @Override
    @Transactional
    public Boolean saveOrUpdateColor(Color color) {
        return colorDao.saveOrUpdateColor(color);
    }

    @Override
    @Transactional
    public void deleteColor(Integer id) {
        colorDao.deleteColor(id);
    }

    @Override
    @Transactional
    public void deleteColor(List<Integer> ids) {
        colorDao.deleteColor(ids);

    }
}
