package com.buimanhthanh.dao.impl;

import com.buimanhthanh.dao.OrderDao;
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
    public Optional<Order> getOrderById(Integer id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession()
                .createQuery("from Order as a where a.id =: i",Order.class)
                .setParameter("i",id)
                .getSingleResult());
    }

    @Override
    public Optional<List<Order>> getAllOrder() {
        return Optional.ofNullable(sessionFactory.getCurrentSession()
                .createQuery("from Order",Order.class)
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
