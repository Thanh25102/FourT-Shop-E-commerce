package com.buimanhthanh.dao;

import com.buimanhthanh.entity.Color;
import com.buimanhthanh.entity.Role;

import java.util.List;
import java.util.Optional;

public interface ColorDao {
    Optional<Color> getColorById(Integer id);

    Optional<List<Color>> getAllColor();

    Boolean saveOrUpdateColor(Color color);

    void deleteColor(Integer id);

    void deleteColor(List<Integer> ids);
}
