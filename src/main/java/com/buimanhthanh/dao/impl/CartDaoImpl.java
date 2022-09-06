package com.buimanhthanh.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buimanhthanh.dao.CartDao;
import com.buimanhthanh.entity.Cart;

@Repository
public class CartDaoImpl implements CartDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Optional<Cart> getCartById(Integer id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession()
                .createQuery("from Cart as a where a.id =: i",Cart.class)
                .setParameter("i",id)
                .getSingleResult());
    }

    @Override
    public Optional<List<Cart>> getAllCart() {
        return Optional.ofNullable(sessionFactory.getCurrentSession()
                .createQuery("from Cart",Cart.class)
                .getResultList());
    }

    @Override
    public Boolean saveOrUpdateCart(Cart cart) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(cart);
            return true;
        } catch (HibernateException e){
            System.out.println( "Error == add Cart" + e.getMessage());
        }
        return false;
    }

    @Override
    public void deleteCart(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Cart cart = session.get(Cart.class, id);
        if(cart!=null)
            session.delete(cart);
    }

    @Override
    public void deleteCart(List<Integer> ids) {
        if(!ids.isEmpty())
            ids.forEach(this::deleteCart);
    }
}
