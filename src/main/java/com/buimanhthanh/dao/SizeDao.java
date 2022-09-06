package com.buimanhthanh.dao;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.entity.Size;

public interface SizeDao {
    Optional<Size> getSizeById(Integer id);

    Optional<List<Size>> getAllSize();

    Boolean saveOrUpdateSize(Size size);

    void deleteSize(Integer id);

    void deleteSize(List<Integer> ids);
}
