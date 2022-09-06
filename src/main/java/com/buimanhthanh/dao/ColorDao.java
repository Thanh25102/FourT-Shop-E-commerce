package com.buimanhthanh.dao;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.entity.Color;

public interface ColorDao {
    Optional<Color> getColorById(Integer id);

    Optional<List<Color>> getAllColor();

    Boolean saveOrUpdateColor(Color color);

    void deleteColor(Integer id);

    void deleteColor(List<Integer> ids);
}
