package com.buimanhthanh.dao.impl;

import com.buimanhthanh.dao.CategoryDao;
import com.buimanhthanh.entity.Access;
import com.buimanhthanh.entity.Category;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryDaoImpl implements CategoryDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Optional<Category> getCategoryById(Integer id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession()
                .createQuery("from Category as a where a.id =: i", Category.class)
                .setParameter("i",id)
                .getSingleResult());
    }

    @Override
    public Optional<List<Category>> getAllCategory() {
        return Optional.ofNullable(sessionFactory.getCurrentSession()
                .createQuery("from Category",Category.class)
                .getResultList());
    }

    @Override
    public Boolean saveOrUpdateCategory(Category category) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(category);
            return true;
        } catch (HibernateException e){
            System.out.println( "Error == add Access" + e.getMessage());
        }
        return false;
    }

    @Override
    public void deleteCategory(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Category category = session.get(Category.class, id);
        if(category!=null)
            session.delete(category);
    }

    @Override
    public void deleteCategory(List<Integer> ids) {

        if(!ids.isEmpty())
            ids.forEach(this::deleteCategory);
    }
}
