package com.buimanhthanh.service;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.dto.AccessDTO;

public interface AccessService {
	Optional<AccessDTO> getAccessById(Integer id);

	Optional<List<AccessDTO>> getAllAccess();

	Boolean saveOrUpdateAccess(AccessDTO accessDTO);

	void deleteAccess(Integer id);

	void deleteAccess(List<Integer> ids);
}
