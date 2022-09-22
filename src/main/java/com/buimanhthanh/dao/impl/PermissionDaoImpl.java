package com.buimanhthanh.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buimanhthanh.dao.PermissionDao;
import com.buimanhthanh.entity.Permission;

@Repository
public class PermissionDaoImpl implements PermissionDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Optional<List<com.buimanhthanh.entity.Permission>> getPermissionByRoleId(Integer id) {
		return Optional.ofNullable(sessionFactory.getCurrentSession()
				.createQuery("from Permission as p where p.roleByRoleId =: i", Permission.class).setParameter("i", id)
				.getResultList());
	}

	@Override
	public Optional<List<com.buimanhthanh.entity.Permission>> getPermissionByAccessId(Integer id) {
		return Optional.ofNullable(sessionFactory.getCurrentSession()
				.createQuery("from Permission as p where p.accessByAccessId =: i", Permission.class)
				.setParameter("i", id).getResultList());
	}

	@Override
	public Optional<List<com.buimanhthanh.entity.Permission>> getAllPermission() {
		return Optional.ofNullable(
				sessionFactory.getCurrentSession().createQuery("from Permission", Permission.class).getResultList());
	}

	@Override
	public Boolean saveOrUpdatePermission(com.buimanhthanh.entity.Permission permission) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(permission);
			return true;
		} catch (HibernateException e) {
			System.out.println("Error == add Permission" + e.getMessage());
		}
		return false;
	}

	@Override
	public void deletePermissionByRoleId(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Permission permission = session.get(Permission.class, id);
		if (permission != null)
			session.delete(permission);
	}

	@Override
	public void deletePermissionByAccessId(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Permission permission = session.get(Permission.class, id);
		if (permission != null)
			session.delete(permission);
	}

}
