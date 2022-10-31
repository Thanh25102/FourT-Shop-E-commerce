package com.buimanhthanh.dao;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.dto.AccessDTO;
import com.buimanhthanh.entity.Access;

public interface AccessDao {
	Optional<AccessDTO> getAccessById(Integer id);

	Optional<List<AccessDTO>> getAllAccess();

	Boolean saveOrUpdateAccess(Access access);

	void deleteAccess(Integer id);

	void deleteAccess(List<Integer> ids);
}
