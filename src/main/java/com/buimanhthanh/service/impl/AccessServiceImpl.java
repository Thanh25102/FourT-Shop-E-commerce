package com.buimanhthanh.service.impl;

import com.buimanhthanh.dao.AccessDao;
import com.buimanhthanh.entity.Access;
import com.buimanhthanh.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AccessServiceImpl implements AccessService {

    @Autowired
    private AccessDao accessDao;

    @Override
    @Transactional
    public Optional<Access> getAccessById(Integer id) {
        return accessDao.getAccessById(id);
    }

    @Override
    @Transactional
    public Optional<List<Access>> getAllAccess() {
        return accessDao.getAllAccess();
    }

    @Override
    @Transactional
    public Boolean saveOrUpdateAccess(Access access) {
        return accessDao.saveOrUpdateAccess(access);
    }

    @Override
    @Transactional
    public void deleteAccess(Integer id) {
        accessDao.deleteAccess(id);
    }

    @Override
    @Transactional
    public void deleteAccess(List<Integer> ids) {
        accessDao.deleteAccess(ids);
    }
}
