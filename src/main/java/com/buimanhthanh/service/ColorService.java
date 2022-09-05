package com.buimanhthanh.service;

import com.buimanhthanh.entity.Color;

import java.util.List;
import java.util.Optional;

public interface ColorService {
    Optional<Color> getColorById(Integer id);

    Optional<List<Color>> getAllColor();

    Boolean saveOrUpdateColor(Color color);

    void deleteColor(Integer id);

    void deleteColor(List<Integer> ids);
}
