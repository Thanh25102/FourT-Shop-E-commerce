package com.buimanhthanh.service;

import com.buimanhthanh.dto.SizeDTO;
import com.buimanhthanh.entity.Size;

import java.util.List;
import java.util.Optional;

public interface SizeService {
    Optional<SizeDTO> getSizeById(Integer id);

    Optional<List<SizeDTO>> getAllSize();

    Boolean saveOrUpdateSize(SizeDTO sizeDTO);

    void deleteSize(Integer id);

    void deleteSize(List<Integer> ids);
}
