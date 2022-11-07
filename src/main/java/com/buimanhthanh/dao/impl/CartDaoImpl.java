package com.buimanhthanh.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buimanhthanh.dao.CartDao;
import com.buimanhthanh.dto.CartDTO;
import com.buimanhthanh.entity.Cart;

@Repository
public class CartDaoImpl implements CartDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Optional<CartDTO> getCartById(Integer id) {
		return sessionFactory.getCurrentSession().createQuery("select new com.buimanhthanh.dto.CartDTO(a.id,a.ammount,a.accountByUsername.username) from Cart a where a.id =: i", CartDTO.class)
				.setParameter("i", id).getResultList().stream().findFirst();
	}

	@Override
	public Optional<List<CartDTO>> getAllCart() {
		return Optional
				.ofNullable(sessionFactory.getCurrentSession().createQuery("select new com.buimanhthanh.dto.CartDTO(a.id,a.ammount,a.accountByUsername.username) from Cart a", CartDTO.class).getResultList());
	}

	@Override
	public Boolean saveOrUpdateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(cart);
			return true;
		} catch (HibernateException e) {
			System.out.println("Error == add Cart" + e.getMessage());
		}
		return false;
	}

	@Override
	public void deleteCart(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Cart cart = session.get(Cart.class, id);
		if (cart != null)
			session.delete(cart);
	}

	@Override
	public void deleteCart(List<Integer> ids) {
		if (!ids.isEmpty())
			ids.forEach(this::deleteCart);
	}

	@Override
	public Optional<CartDTO> getCartByUsername(String username) {
		return sessionFactory.getCurrentSession()
				.createQuery("select new com.buimanhthanh.dto.CartDTO(a.id,a.ammount,a.accountByUsername.username) from Cart a where a.username =: u", CartDTO.class)
				.setParameter("u", username).getResultList().stream().findFirst();
	}
}
