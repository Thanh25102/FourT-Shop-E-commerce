package com.buimanhthanh.service.impl;

import com.buimanhthanh.dao.ColorDao;
import com.buimanhthanh.dto.ColorDTO;
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
    public Optional<ColorDTO> getColorById(Integer id) {
        return colorDao.getColorById(id);
    }

    @Override
    @Transactional
    public Optional<List<ColorDTO>> getAllColor() {
        return colorDao.getAllColor();
    }

    @Override
    @Transactional
    public Boolean saveOrUpdateColor(ColorDTO colorDTO) {
    	Color color = new Color(colorDTO.getId(),colorDTO.getName(),colorDTO.getCode(),colorDTO.getDescription(),null);
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
