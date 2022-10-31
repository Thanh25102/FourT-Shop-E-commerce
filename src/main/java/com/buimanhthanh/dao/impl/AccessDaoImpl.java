package com.buimanhthanh.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buimanhthanh.dao.AccessDao;
import com.buimanhthanh.dto.AccessDTO;
import com.buimanhthanh.entity.Access;

@Repository
public class AccessDaoImpl implements AccessDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Optional<AccessDTO> getAccessById(Integer id) {
		return sessionFactory.getCurrentSession()
				.createQuery("select new com.buimanhthanh.dto.AccessDTO(a.id,a.code,a.description) from Access a where a.id =: i",AccessDTO.class)
				.setParameter("i",id)
				.getResultList().stream().findFirst();
	}

	@Override
	public Optional<List<AccessDTO>> getAllAccess() {
		return Optional.ofNullable(sessionFactory.getCurrentSession()
				.createQuery("select new com.buimanhthanh.dto.AccessDTO(a.id,a.code,a.description) from Access a",AccessDTO.class)
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
