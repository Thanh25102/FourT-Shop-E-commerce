package com.buimanhthanh.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buimanhthanh.dao.DiscountDao;
import com.buimanhthanh.entity.Discount;

@Repository
public class DiscountDaoImpl implements DiscountDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Optional<Discount> getDiscountById(Integer id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession()
                .createQuery("from Discount as a where a.id =: i",Discount.class)
                .setParameter("i",id)
                .getSingleResult());
    }

    @Override
    public Optional<List<Discount>> getAllDiscount() {
        return Optional.ofNullable(sessionFactory.getCurrentSession()
                .createQuery("from Discount",Discount.class)
                .getResultList());
    }

    @Override
    public Boolean saveOrUpdateDiscount(Discount discount) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(discount);
            return true;
        } catch (HibernateException e){
            System.out.println( "Error == add Discount" + e.getMessage());
        }
        return false;
    }

    @Override
    public void deleteDiscount(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Discount discount = session.get(Discount.class, id);
        if(discount!=null)
            session.delete(discount);
    }

    @Override
    public void deleteDiscount(List<Integer> ids) {
        if(!ids.isEmpty())
            ids.forEach(this::deleteDiscount);
    }
}
