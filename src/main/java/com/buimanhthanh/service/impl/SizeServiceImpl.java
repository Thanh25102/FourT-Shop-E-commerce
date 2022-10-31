package com.buimanhthanh.service.impl;

import com.buimanhthanh.dao.SizeDao;
import com.buimanhthanh.dto.SizeDTO;
import com.buimanhthanh.entity.Size;
import com.buimanhthanh.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SizeServiceImpl implements SizeService {
    @Autowired
    private SizeDao sizeDao;

    @Override
    @Transactional
    public Optional<SizeDTO> getSizeById(Integer id) {
        return sizeDao.getSizeById(id);
    }

    @Override
    @Transactional
    public Optional<List<SizeDTO>> getAllSize() {
        return sizeDao.getAllSize();
    }

    @Override
    @Transactional
    public Boolean saveOrUpdateSize(SizeDTO sizeDTO) {
    	Size size = new Size(sizeDTO.getId(),sizeDTO.getName(),sizeDTO.getCode(),sizeDTO.getDescription(),null);
        return sizeDao.saveOrUpdateSize(size);
    }

    @Override
    @Transactional
    public void deleteSize(Integer id) {
        sizeDao.deleteSize(id);
    }

    @Override
    @Transactional
    public void deleteSize(List<Integer> ids) {
        sizeDao.deleteSize(ids);
    }
}
