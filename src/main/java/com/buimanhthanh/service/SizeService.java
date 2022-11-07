package com.buimanhthanh.service;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.dto.SizeDTO;

public interface SizeService {
    Optional<SizeDTO> getSizeById(Integer id);

    Optional<List<SizeDTO>> getAllSize();

    Boolean saveOrUpdateSize(SizeDTO sizeDTO);

    void deleteSize(Integer id);

    void deleteSize(List<Integer> ids);
}
