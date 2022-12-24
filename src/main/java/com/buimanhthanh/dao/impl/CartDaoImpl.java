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
		StringBuilder sql = new StringBuilder(
				"select new com.buimanhthanh.dto.CartDetailDTO(cd.id,p.id,cd.cartByCartId.id,cd.price,cd.quantity,p.name,pd.image,d.salePercent,p.price)");
		sql.append(" from CartDetail cd ");
		sql.append("	inner join ProductDetail pd on cd.productDetailByProductId.id = pd.id ");
		sql.append(" 	inner join Product p on p.id = pd.productByProductId.id");
		sql.append(" 	LEFT JOIN Discount d on p.discountByDiscountId.id = d.id");
		sql.append(" 		where cd.cartByCartId.id =: i");
		return Optional.ofNullable(sessionFactory.getCurrentSession().createQuery(sql.toString(), CartDetailDTO.class)
				.setParameter("i", cartId).getResultList());
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
		StringBuilder sql = new StringBuilder(
				"select new com.buimanhthanh.dto.CartDetailDTO(cd.id,p.id,cd.cartByCartId.id,cd.price,cd.quantity,p.name,pd.image,d.salePercent,p.price)");
		sql.append(" from CartDetail cd ");
		sql.append("	inner join ProductDetail pd on cd.productDetailByProductId.id = pd.id ");
		sql.append(" 	inner join Product p on p.id = pd.productByProductId.id");
		sql.append(" 	LEFT JOIN Discount d on p.discountByDiscountId.id = d.id");
		sql.append(" 		where pd =: i and cd.cartByCartId.id =: c");

		return sessionFactory.getCurrentSession().createQuery(sql.toString(), CartDetailDTO.class)
				.setParameter("i", productDetailId).setParameter("c", cartId).getResultList().stream().findFirst();
	}

	@Override
	public Optional<CartDetailDTO> getCartDetailById(Integer id) {
		StringBuilder sql = new StringBuilder(
				"select new com.buimanhthanh.dto.CartDetailDTO(cd.id,p.id,cd.cartByCartId.id,cd.price,cd.quantity,p.name,pd.image,d.salePercent,p.price)");
		sql.append(" from CartDetail cd ");
		sql.append("	inner join ProductDetail pd on cd.productDetailByProductId.id = pd.id ");
		sql.append(" 	inner join Product p on p.id = pd.productByProductId.id");
		sql.append(" 	LEFT JOIN Discount d on p.discountByDiscountId.id = d.id");
		sql.append(" 		where cd.id =: i");

		return sessionFactory.getCurrentSession().createQuery(sql.toString(), CartDetailDTO.class).setParameter("i", id)
				.getResultList().stream().findFirst();
	}

	@Override
	public Integer getQuantityOfCart(int cartId) {
		return sessionFactory.getCurrentSession()
				.createQuery("select SUM(c.quantity) from CartDetail c where c.cartByCartId.id =: i", Long.class)
				.setParameter("i", cartId).getSingleResult().intValue();
	}
}
