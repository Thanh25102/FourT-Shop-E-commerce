package com.buimanhthanh.dao;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.entity.Role;

public interface RoleDao {
    Optional<Role> getRoleById(Integer id);
    
    Optional<Role> getRoleByAuthority(String authority);

    Optional<List<Role>> getAllRole();

    Boolean saveOrUpdateRole(Role role);

    void deleteRole(Integer id);

    void deleteRole(List<Integer> ids);
}
