package com.buimanhthanh.dao;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.dto.ColorDTO;
import com.buimanhthanh.entity.Color;

public interface ColorDao {
    Optional<ColorDTO> getColorById(Integer id);

    Optional<List<ColorDTO>> getAllColor();

    Boolean saveOrUpdateColor(Color color);

    void deleteColor(Integer id);

    void deleteColor(List<Integer> ids);
}
