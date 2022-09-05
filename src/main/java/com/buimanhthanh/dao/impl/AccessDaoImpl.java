package com.buimanhthanh.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buimanhthanh.dao.AccessDao;
import com.buimanhthanh.entity.Access;

@Repository
public class AccessDaoImpl implements AccessDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Optional<Access> getAccessById(Integer id) {
		return Optional.ofNullable(sessionFactory.getCurrentSession()
				.createQuery("from Access as a where a.id =: i",Access.class)
				.setParameter("i",id)
				.getSingleResult());
	}

	@Override
	public Optional<List<Access>> getAllAccess() {
		return Optional.ofNullable(sessionFactory.getCurrentSession()
				.createQuery("from Access",Access.class)
				.getResultList());
	}

	@Override
	public Boolean saveOrUpdateAccess(Access access) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(access);
			return true;
		} catch (HibernateException e){
			System.out.println( "Error == add Access" + e.getMessage());
		}
		return false;
	}

	@Override
	public void deleteAccess(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Access access = session.get(Access.class, id);
		if(access!=null)
			session.delete(access);
	}

	@Override
	public void deleteAccess(List<Integer> ids) {
		if(!ids.isEmpty())
			ids.forEach(this::deleteAccess);
	}

}
