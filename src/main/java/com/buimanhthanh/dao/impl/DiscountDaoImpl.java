package com.buimanhthanh.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buimanhthanh.dao.DiscountDao;
import com.buimanhthanh.dto.DiscountDTO;
import com.buimanhthanh.entity.Discount;

@Repository
public class DiscountDaoImpl implements DiscountDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Optional<DiscountDTO> getDiscountById(Integer id) {
		return sessionFactory.getCurrentSession().createQuery("select new com.buimanhthanh.dto.DiscountDTO(a.id,a.salePercent,a.startDay,a.endDay,a.description) from Discount a where a.id =: i", DiscountDTO.class)
				.setParameter("i", id).getResultList().stream().findFirst();
	}

	@Override
	public Optional<List<DiscountDTO>> getAllDiscount() {
		return Optional.ofNullable(
				sessionFactory.getCurrentSession()
				.createQuery("select new com.buimanhthanh.dto.DiscountDTO(a.id,a.salePercent,a.startDay,a.endDay,a.description) from Discount a", DiscountDTO.class)
				.getResultList());
	}

	@Override
	public Boolean saveOrUpdateDiscount(Discount discount) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(discount);
			return true;
		} catch (HibernateException e) {
			System.out.println("Error == add Discount" + e.getMessage());
		}
		return false;
	}

	@Override
	public void deleteDiscount(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Discount discount = session.get(Discount.class, id);
		if (discount != null)
			session.delete(discount);
	}

	@Override
	public void deleteDiscount(List<Integer> ids) {
		if (!ids.isEmpty())
			ids.forEach(this::deleteDiscount);
	}
}
