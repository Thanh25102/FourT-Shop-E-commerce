package com.buimanhthanh.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buimanhthanh.dao.SizeDao;
import com.buimanhthanh.entity.Size;

@Repository
public class SizeDaoImpl implements SizeDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Optional<Size> getSizeById(Integer id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession()
                .createQuery("from Size as a where a.id =: i",Size.class)
                .setParameter("i",id)
                .getSingleResult());
    }

    @Override
    public Optional<List<Size>> getAllSize() {
        return Optional.ofNullable(sessionFactory.getCurrentSession()
                .createQuery("from Size",Size.class)
                .getResultList());
    }

    @Override
    public Boolean saveOrUpdateSize(Size size) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(size);
            return true;
        } catch (HibernateException e){
            System.out.println( "Error == add Size" + e.getMessage());
        }
        return false;
    }

    @Override
    public void deleteSize(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Size size = session.get(Size.class, id);
        if(size!=null)
            session.delete(size);
    }

    @Override
    public void deleteSize(List<Integer> ids) {
        if(!ids.isEmpty())
            ids.forEach(this::deleteSize);
    }
}
