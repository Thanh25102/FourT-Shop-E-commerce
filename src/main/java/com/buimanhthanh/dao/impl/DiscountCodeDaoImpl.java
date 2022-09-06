package com.buimanhthanh.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buimanhthanh.dao.DiscountCodeDao;
import com.buimanhthanh.entity.DiscountCode;

@Repository
public class DiscountCodeDaoImpl implements DiscountCodeDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Optional<DiscountCode> getDiscountCodeById(Integer id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession()
                .createQuery("from DiscountCode as a where a.id =: i",DiscountCode.class)
                .setParameter("i",id)
                .getSingleResult());
    }

    @Override
    public Optional<List<DiscountCode>> getAllDiscountCode() {
        return Optional.ofNullable(sessionFactory.getCurrentSession()
                .createQuery("from DiscountCode",DiscountCode.class)
                .getResultList());
    }

    @Override
    public Boolean saveOrUpdateDiscountCode(DiscountCode discountCode) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(discountCode);
            return true;
        } catch (HibernateException e){
            System.out.println( "Error == add Discount Code" + e.getMessage());
        }
        return false;
    }

    @Override
    public void deleteDiscountCode(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        DiscountCode discountCode = session.get(DiscountCode.class, id);
        if(discountCode!=null)
            session.delete(discountCode);
    }

    @Override
    public void deleteDiscountCode(List<Integer> ids) {
        if(!ids.isEmpty())
            ids.forEach(this::deleteDiscountCode);
    }
}
