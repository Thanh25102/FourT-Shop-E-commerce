package com.buimanhthanh.dao;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.dto.SizeDTO;
import com.buimanhthanh.entity.Size;

public interface SizeDao {
    Optional<SizeDTO> getSizeById(Integer id);

    Optional<List<SizeDTO>> getAllSize();

    Boolean saveOrUpdateSize(Size size);

    void deleteSize(Integer id);

    void deleteSize(List<Integer> ids);
}
