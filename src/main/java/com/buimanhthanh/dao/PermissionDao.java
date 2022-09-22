package com.buimanhthanh.dao;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.entity.Permission;

public interface PermissionDao {
	Optional<List<Permission>> getPermissionByRoleId(Integer id);

	Optional<List<Permission>> getPermissionByAccessId(Integer id);

	Optional<List<Permission>> getAllPermission();

	Boolean saveOrUpdatePermission(Permission permission);

	void deletePermissionByRoleId(Integer id);

	void deletePermissionByAccessId(Integer id);
}
