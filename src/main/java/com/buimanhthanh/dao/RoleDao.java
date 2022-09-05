package com.buimanhthanh.dao;

import com.buimanhthanh.entity.Access;
import com.buimanhthanh.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleDao {
    Optional<Role> getRoleById(Integer id);

    Optional<List<Role>> getAllRole();

    Boolean saveOrUpdateRole(Role role);

    void deleteRole(Integer id);

    void deleteRole(List<Integer> ids);
}
