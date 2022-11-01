package com.buimanhthanh.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buimanhthanh.dao.CategoryDao;
import com.buimanhthanh.dto.CategoryDTO;
import com.buimanhthanh.dto.CategoryRangeDTO;
import com.buimanhthanh.entity.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Optional<CategoryDTO> getCategoryById(Integer id) {
        return sessionFactory.getCurrentSession()
                .createQuery("select new com.buimanhthanh.dto.CategoryDTO(a.id,a.name,a.code,a.thumbnail,a.description,a.logo) from Category a where a.id =: i", CategoryDTO.class)
                .setParameter("i",id)
                .getResultList().stream().findFirst();
    }
    @Override
    public Optional<List<CategoryRangeDTO>> getCategoryRange() {
        return Optional.ofNullable(sessionFactory.getCurrentSession()
                .createQuery("select new com.buimanhthanh.dto.CategoryRangeDTO(c.id, count(p.id)) from Category c inner join Product p on p.categoryByCategoryId.id = c.id group by c.id", CategoryRangeDTO.class)
                .getResultList());
    }

    @Override
    public Optional<List<CategoryDTO>> getAllCategory() {
        return Optional.ofNullable(sessionFactory.getCurrentSession()
                .createQuery("select new com.buimanhthanh.dto.CategoryDTO(a.id,a.name,a.code,a.thumbnail,a.description,a.logo) from Category a",CategoryDTO.class)
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
