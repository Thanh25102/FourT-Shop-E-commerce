package com.buimanhthanh.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buimanhthanh.dao.PermissionDao;
import com.buimanhthanh.entity.Permission;
import com.buimanhthanh.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService{

	@Autowired
	private PermissionDao permissionDao;
	
	@Override
	@Transactional
	public Optional<List<Permission>> getPermissionByRoleId(Integer id) {
		return permissionDao.getPermissionByRoleId(id);
	}

	@Override
	@Transactional
	public Optional<List<Permission>> getPermissionByAccessId(Integer id) {
		return permissionDao.getPermissionByAccessId(id);
	}

	@Override
	@Transactional
	public Optional<List<Permission>> getAllPermission() {
		return permissionDao.getAllPermission();
	}

	@Override
	@Transactional
	public Boolean saveOrUpdatePermission(Permission permission) {
		return permissionDao.saveOrUpdatePermission(permission);
	}

	@Override
	@Transactional
	public void deletePermissionByRoleId(Integer id) {
		permissionDao.deletePermissionByRoleId(id);
	}

	@Override
	@Transactional
	public void deletePermissionByAccessId(Integer id) {
		permissionDao.deletePermissionByAccessId(id);
	}

}
