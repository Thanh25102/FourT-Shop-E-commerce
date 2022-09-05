package com.buimanhthanh.service;

import com.buimanhthanh.entity.Access;

import java.util.List;
import java.util.Optional;

public interface AccessService {
	Optional<Access> getAccessById(Integer id);

	Optional<List<Access>> getAllAccess();

	Boolean saveOrUpdateAccess(Access access);

	void deleteAccess(Integer id);

	void deleteAccess(List<Integer> ids);
}
