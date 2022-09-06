package com.buimanhthanh.service.impl;

import com.buimanhthanh.dao.RoleDao;
import com.buimanhthanh.entity.Role;
import com.buimanhthanh.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    @Transactional
    public Optional<Role> getRoleById(Integer id) {
        return roleDao.getRoleById(id);
    }
    
    @Override
    @Transactional
    public Optional<Role> getRoleByAuthority(String authority) {
        return roleDao.getRoleByAuthority(authority);
    }

    @Override
    @Transactional
    public Optional<List<Role>> getAllRole() {
        return roleDao.getAllRole();
    }

    @Override
    @Transactional
    public Boolean saveOrUpdateRole(Role role) {
        return roleDao.saveOrUpdateRole(role);
    }

    @Override
    @Transactional
    public void deleteRole(Integer id) {
        roleDao.deleteRole(id);
    }

    @Override
    @Transactional
    public void deleteRole(List<Integer> ids) {
        roleDao.deleteRole(ids);
    }
}
