package com.buimanhthanh.service;

import com.buimanhthanh.entity.Size;

import java.util.List;
import java.util.Optional;

public interface SizeService {
    Optional<Size> getSizeById(Integer id);

    Optional<List<Size>> getAllSize();

    Boolean saveOrUpdateSize(Size size);

    void deleteSize(Integer id);

    void deleteSize(List<Integer> ids);
}
