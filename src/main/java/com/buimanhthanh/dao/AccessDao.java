package com.buimanhthanh.dao;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.entity.Access;

public interface AccessDao {
	Optional<Access> getAccessById(Integer id);

	Optional<List<Access>> getAllAccess();

	Boolean saveOrUpdateAccess(Access access);

	void deleteAccess(Integer id);

	void deleteAccess(List<Integer> ids);
}
