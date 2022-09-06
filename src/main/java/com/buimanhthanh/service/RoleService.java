package com.buimanhthanh.service;

import com.buimanhthanh.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    Optional<Role> getRoleById(Integer id);
    
    Optional<Role> getRoleByAuthority(String authority);

    Optional<List<Role>> getAllRole();

    Boolean saveOrUpdateRole(Role role);

    void deleteRole(Integer id);

    void deleteRole(List<Integer> ids);
}
