package com.buimanhthanh.dao.impl;

import com.buimanhthanh.dao.OrderDao;
import com.buimanhthanh.dto.OrderDTO;
import com.buimanhthanh.entity.Order;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Optional<OrderDTO> getOrderById(Integer id) {
        return sessionFactory.getCurrentSession()
                .createQuery("select new com.buimanhthanh.dto.OrderDTO(a.id,a.accountByUsername.username,a.orderStatus,a.ammount,a.paymentMethod,a.createTime,a.discountCodeByDiscountCodeId.id) from Order as a where a.id =: i",OrderDTO.class)
                .setParameter("i",id)
                .getResultList().stream().findFirst();
    }

    @Override
    public Optional<List<OrderDTO>> getAllOrder() {
        return Optional.ofNullable(sessionFactory.getCurrentSession()
                .createQuery("select new com.buimanhthanh.dto.OrderDTO(a.id,a.accountByUsername.username,a.orderStatus,a.ammount,a.paymentMethod,a.createTime,a.discountCodeByDiscountCodeId.id) from Order a",OrderDTO.class)
                .getResultList());
    }

    @Override
    public Boolean saveOrUpdateOrder(Order order) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(order);
            return true;
        } catch (HibernateException e){
            System.out.println( "Error == add Order" + e.getMessage());
        }
        return false;
    }

    @Override
    public void deleteOrder(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Order order = session.get(Order.class, id);
        if(order!=null)
            session.delete(order);
    }

    @Override
    public void deleteOrder(List<Integer> ids) {
        if(!ids.isEmpty())
            ids.forEach(this::deleteOrder);
    }
}
