package com.buimanhthanh.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buimanhthanh.dao.OrderDao;
import com.buimanhthanh.dto.OrderDTO;
import com.buimanhthanh.dto.OrderDetailDTO;
import com.buimanhthanh.dto.RevenueDTO;
import com.buimanhthanh.entity.Order;
import com.buimanhthanh.entity.OrderDetail;

@Repository
public class OrderDaoImpl implements OrderDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Optional<OrderDTO> getOrderById(Integer id) {
		return sessionFactory.getCurrentSession().createQuery(
				"select new com.buimanhthanh.dto.OrderDTO(a.id,a.accountByUsername.username,a.orderStatus,a.ammount,a.paymentMethod,a.createTime,a.phone,a.shipingAddress,a.city,a.discountCodeByDiscountCodeId.id,a.sumMoney) from Order as a where a.id =: i",
				OrderDTO.class).setParameter("i", id).getResultList().stream().findFirst();
	}

	@Override
	public Optional<List<OrderDTO>> getAllOrder() {
		return Optional.ofNullable(sessionFactory.getCurrentSession().createQuery(
				"select new com.buimanhthanh.dto.OrderDTO(a.id,a.accountByUsername.username,a.orderStatus,a.ammount,a.paymentMethod,a.createTime,a.phone,a.shipingAddress,a.city,a.discountCodeByDiscountCodeId.id,a.sumMoney) from Order a",
				OrderDTO.class).getResultList());
	}

	@Override
	public Optional<List<OrderDTO>> getOrderByUsername(String username) {
		return Optional.ofNullable(sessionFactory.getCurrentSession().createQuery(
				"select new com.buimanhthanh.dto.OrderDTO(a.id,a.accountByUsername.username,a.orderStatus,a.ammount,a.paymentMethod,a.createTime,a.phone,a.shipingAddress,a.city,a.discountCodeByDiscountCodeId.id,a.sumMoney) from Order a where a.accountByUsername.username =: u",
				OrderDTO.class).setParameter("u", username).getResultList());
	}

	@Override
	public Boolean saveOrUpdateOrder(Order order) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(order);
			return true;
		} catch (HibernateException e) {
			System.out.println("Error == add Order" + e.getMessage());
		}
		return false;
	}

	@Override
	public Integer saveOrder(Order order) {
		System.out.println(order.toString());
		try {
			return (Integer) sessionFactory.getCurrentSession().save(order);
		} catch (HibernateException e) {
			System.out.println("Error == add Order" + e.getMessage());
		}
		return -1;
	}

	@Override
	public Boolean saveOrUpdateOrderDetail(OrderDetail orderDetail) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(orderDetail);
			return true;
		} catch (HibernateException e) {
			System.out.println("Error == add Order" + e.getMessage());
		}
		return false;
	}

	@Override
	public void deleteOrder(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Order order = session.get(Order.class, id);
		if (order != null)
			session.delete(order);
	}

	@Override
	public void deleteOrder(List<Integer> ids) {
		if (!ids.isEmpty())
			ids.forEach(this::deleteOrder);
	}

	@Override
	public Optional<List<OrderDetailDTO>> getOrderDetailByOrderId(Integer id) {
		return Optional.ofNullable(sessionFactory.getCurrentSession().createQuery(
				"select new com.buimanhthanh.dto.OrderDetailDTO(a.id,a.productDetailByProductId.id,a.orderByOrderId.id,a.price,a.quantity,a.productDetailByProductId.productByProductId.name) from OrderDetail a where a.orderByOrderId.id =: i",
				OrderDetailDTO.class).setParameter("i", id).getResultList());
	}

	@Override
	public Optional<List<OrderDetailDTO>> getAllOrderDetailComplete() {
		return Optional.ofNullable(sessionFactory.getCurrentSession().createQuery(
				"select new com.buimanhthanh.dto.OrderDetailDTO(a.id,a.productDetailByProductId.id,a.orderByOrderId.id,a.price,a.quantity,a.productDetailByProductId.productByProductId.name) from OrderDetail a where a.orderByOrderId.orderStatus = 'COMPLETE'",
				OrderDetailDTO.class).getResultList());
	}

	@Override
	public Optional<List<OrderDetailDTO>> getAllOrderDetailComplete(Month month) {
		return Optional.ofNullable(sessionFactory.getCurrentSession().createQuery(
				"select new com.buimanhthanh.dto.OrderDetailDTO(a.id,a.productDetailByProductId.id,a.orderByOrderId.id,a.price,a.quantity,a.productDetailByProductId.productByProductId.name) from OrderDetail a where MONTH(a.orderByOrderId.createTime) = :d and a.orderByOrderId.orderStatus = 'COMPLETE'",
				OrderDetailDTO.class).setParameter("d", month.getValue()).getResultList());
	}

	@Override
	public Optional<List<OrderDTO>> getAllOrderPending() {
		return Optional.ofNullable(sessionFactory.getCurrentSession().createQuery(
				"select new com.buimanhthanh.dto.OrderDTO(a.id,a.accountByUsername.username,a.orderStatus,a.ammount,a.paymentMethod,a.createTime,a.phone,a.shipingAddress,a.city,a.discountCodeByDiscountCodeId.id,a.sumMoney) from Order a where a.orderStatus = 'PENDING'",
				OrderDTO.class).getResultList());
	}

	@Override
	public Optional<List<OrderDTO>> getAllOrderDelevering() {
		return Optional.ofNullable(sessionFactory.getCurrentSession().createQuery(
				"select new com.buimanhthanh.dto.OrderDTO(a.id,a.accountByUsername.username,a.orderStatus,a.ammount,a.paymentMethod,a.createTime,a.phone,a.shipingAddress,a.city,a.discountCodeByDiscountCodeId.id,a.sumMoney) from Order a where a.orderStatus = 'DELIVERING'",
				OrderDTO.class).getResultList());
	}

	@Override
	public Optional<List<OrderDTO>> getAllOrderComplete() {
		return Optional.ofNullable(sessionFactory.getCurrentSession().createQuery(
				"select new com.buimanhthanh.dto.OrderDTO(a.id,a.accountByUsername.username,a.orderStatus,a.ammount,a.paymentMethod,a.createTime,a.phone,a.shipingAddress,a.city,a.discountCodeByDiscountCodeId.id,a.sumMoney) from Order a where a.orderStatus = 'COMPLETE'",
				OrderDTO.class).getResultList());
	}

	@Override
	public Optional<List<RevenueDTO>> getEarningYear(int year) {
		System.out.println("YEAR : " + year);
		try {
			return Optional.ofNullable(sessionFactory.getCurrentSession().createQuery(
					"SELECT new com.buimanhthanh.dto.RevenueDTO( MONTH(o.createTime),SUM(od.price * od.quantity)) "
							+ " FROM Order o INNER JOIN o.orderDetailsById od "
							+ " WHERE o.createTime BETWEEN :startYear AND :endYear " + " GROUP BY MONTH(o.createTime)",
					RevenueDTO.class)
					.setParameter("startYear", new SimpleDateFormat("yyyy-MM-dd").parse(year + "-01-01"))
					.setParameter("endYear", new SimpleDateFormat("yyyy-MM-dd").parse(year + "-12-31"))
					.getResultList());
		} catch (HibernateException e) {
			return null;
		} catch (ParseException e) {
			return null;
		}
	}

}
