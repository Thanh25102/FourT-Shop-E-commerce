package com.buimanhthanh.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buimanhthanh.dao.DiscountCodeDao;
import com.buimanhthanh.dto.DiscountCodeDTO;
import com.buimanhthanh.entity.DiscountCode;

@Repository
public class DiscountCodeDaoImpl implements DiscountCodeDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Optional<DiscountCodeDTO> getDiscountCodeById(Integer id) {
        return sessionFactory.getCurrentSession()
                .createQuery("select new com.buimanhthanh.dto.DiscountCodeDTO(a.id,a.code,a.salePercent,a.saleMoney,a.startDay,a.endDay,a.maxDiscount,a.description) from DiscountCode as a where a.id =: i",DiscountCodeDTO.class)
                .setParameter("i",id)
                .getResultList().stream().findFirst();
    }

    @Override
    public Optional<List<DiscountCodeDTO>> getAllDiscountCode() {
        return Optional.ofNullable(sessionFactory.getCurrentSession()
                .createQuery("select new com.buimanhthanh.dto.DiscountCodeDTO(a.id,a.code,a.salePercent,a.saleMoney,a.startDay,a.endDay,a.maxDiscount,a.description) from DiscountCode a",DiscountCodeDTO.class)
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
