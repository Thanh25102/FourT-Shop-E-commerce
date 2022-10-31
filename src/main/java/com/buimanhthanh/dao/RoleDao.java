package com.buimanhthanh.dao;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.dto.RoleDTO;
import com.buimanhthanh.entity.Role;

public interface RoleDao {
    Optional<RoleDTO> getRoleById(Integer id);
    
    Optional<RoleDTO> getRoleByAuthority(String authority);

    Optional<List<RoleDTO>> getAllRole();

    Boolean saveOrUpdateRole(Role role);

    void deleteRole(Integer id);

    void deleteRole(List<Integer> ids);
}
