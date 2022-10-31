package com.buimanhthanh.service;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.dto.RoleDTO;

public interface RoleService {
    Optional<RoleDTO> getRoleById(Integer id);
    
    Optional<RoleDTO> getRoleByAuthority(String authority);

    Optional<List<RoleDTO>> getAllRole();

    Boolean saveOrUpdateRole(RoleDTO roleDTO);

    void deleteRole(Integer id);

    void deleteRole(List<Integer> ids);
}
