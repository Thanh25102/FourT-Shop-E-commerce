package com.buimanhthanh.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buimanhthanh.dao.ColorDao;
import com.buimanhthanh.dto.ColorDTO;
import com.buimanhthanh.entity.Color;

@Repository
public class ColorDaoImpl implements ColorDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Optional<ColorDTO> getColorById(Integer id) {
        return sessionFactory.getCurrentSession()
                .createQuery("select new com.buimanhthanh.dto.ColorDTO(a.id,a.name,a.code,a.description) from Color a where a.id =: i",ColorDTO.class)
                .setParameter("i",id)
                .getResultList().stream().findFirst();
    }

    @Override
    public Optional<List<ColorDTO>> getAllColor() {
        return Optional.ofNullable(sessionFactory.getCurrentSession()
                .createQuery("select new com.buimanhthanh.dto.ColorDTO(a.id,a.name,a.code,a.description) from Color a",ColorDTO.class)
                .getResultList());
    }

    @Override
    public Boolean saveOrUpdateColor(Color color) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(color);
            return true;
        } catch (HibernateException e){
            System.out.println( "Error == add Color" + e.getMessage());
        }
        return false;
    }

    @Override
    public void deleteColor(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Color color = session.get(Color.class, id);
        if(color!=null)
            session.delete(color);
    }

    @Override
    public void deleteColor(List<Integer> ids) {
        if(!ids.isEmpty())
            ids.forEach(this::deleteColor);
    }
}
