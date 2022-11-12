package com.buimanhthanh.dao.impl;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.dto.CartDetailDTO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buimanhthanh.dao.CartDao;
import com.buimanhthanh.dto.CartDTO;
import com.buimanhthanh.entity.Cart;
import com.buimanhthanh.entity.CartDetail;

@Repository
public class CartDaoImpl implements CartDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Optional<CartDTO> getCartById(Integer id) {
		return sessionFactory.getCurrentSession().createQuery(
				"select new com.buimanhthanh.dto.CartDTO(a.id,a.ammount,a.accountByUsername.username) from Cart a where a.id =: i",
				CartDTO.class).setParameter("i", id).getResultList().stream().findFirst();
	}

	@Override
	public Optional<List<CartDTO>> getAllCart() {
		return Optional.ofNullable(sessionFactory.getCurrentSession().createQuery(
				"select new com.buimanhthanh.dto.CartDTO(a.id,a.ammount,a.accountByUsername.username) from Cart a",
				CartDTO.class).getResultList());
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
		return sessionFactory.getCurrentSession().createQuery(
				"select new com.buimanhthanh.dto.CartDTO(a.id,a.ammount,a.accountByUsername.username) from Cart a where a.accountByUsername.username =: u",
				CartDTO.class).setParameter("u", username).getResultList().stream().findFirst();
	}

	@Override
	public Optional<List<CartDetailDTO>> getCartDetailByCart(Integer cartId) {
		return Optional.ofNullable(sessionFactory.getCurrentSession().createQuery(
				"select new com.buimanhthanh.dto.CartDetailDTO(a.id,a.productDetailByProductId.id,a.cartByCartId.id,a.price,a.quantity,a.productDetailByProductId.productByProductId.name,a.productDetailByProductId.image) from CartDetail a where a.cartByCartId.id =: i",
				CartDetailDTO.class).setParameter("i", cartId).getResultList());
	}

	@Override
	public Boolean saveOrUpdateCartDetail(CartDetail cartDetail) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(cartDetail);
			return true;
		} catch (HibernateException e) {
			System.out.println("Error == add Cart detail" + e.getMessage());
		}
		return false;
	}

	@Override
	public Integer removeProductFromCart(Integer cartDetailId) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("delete from CartDetail c where c.id =: i").setParameter("i", cartDetailId)
				.executeUpdate();
	}

	@Override
	public Integer getQuantityOfCart(String username) {
		Long quantity = (Long) sessionFactory.getCurrentSession()
				.createQuery("select count(*) from CartDetail c where c.cartByCartId.accountByUsername.username =: u")
				.setParameter("u", username).uniqueResult();
		return quantity.intValue();
	}

	@Override
	public Integer getQuantityOfCartDetail(Integer cartDetailId) {
		return sessionFactory.getCurrentSession()
				.createQuery("select c.quantity from CartDetail c where c.id =: i", Integer.class)
				.setParameter("i", cartDetailId).getSingleResult();
	}

	@Override
	public Boolean isExistProductDetailInCart(Integer productDetailId, Integer cartId) {
		// check productDetail has exist in cart
		return sessionFactory.getCurrentSession().createQuery(
				"select count(*) from CartDetail c where c.cartByCartId.id =: i and c.productDetailByProductId.id =: p",
				Long.class).setParameter("i", cartId).setParameter("p", productDetailId).uniqueResult() != 0;
	}

	@Override
	public Boolean updateQuantityProductDetailInCartDetail(Integer quantity, Integer cartDetailId) {
		Long row = (long) sessionFactory.getCurrentSession()
				.createQuery("update CartDetail c set c.quantity =: q where c.id =: i", Long.class)
				.setParameter("i", cartDetailId).setParameter("q", quantity).executeUpdate();
		return row != 0;
	}

	@Override
	public Optional<CartDetailDTO> getCartDetailByProductDetailId(Integer productDetailId, Integer cartId) {
		return sessionFactory.getCurrentSession().createQuery(
				"select new com.buimanhthanh.dto.CartDetailDTO(a.id,a.productDetailByProductId.id,a.cartByCartId.id,a.price,a.quantity) from CartDetail a where a.productDetailByProductId.id =: i and a.cartByCartId.id =: c",
				CartDetailDTO.class).setParameter("i", productDetailId).setParameter("c", cartId).getResultList()
				.stream().findFirst();
	}

	@Override
	public Optional<CartDetailDTO> getCartDetailById(Integer id) {
		return sessionFactory.getCurrentSession().createQuery(
				"select new com.buimanhthanh.dto.CartDetailDTO(a.id,a.productDetailByProductId.id,a.cartByCartId.id,a.price,a.quantity) from CartDetail a where a.id =: i",
				CartDetailDTO.class).setParameter("i", id).getResultList().stream().findFirst();
	}
}
