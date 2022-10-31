package com.buimanhthanh.service;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.dto.ColorDTO;

public interface ColorService {
    Optional<ColorDTO> getColorById(Integer id);

    Optional<List<ColorDTO>> getAllColor();

    Boolean saveOrUpdateColor(ColorDTO colorDTO);

    void deleteColor(Integer id);

    void deleteColor(List<Integer> ids);
}
