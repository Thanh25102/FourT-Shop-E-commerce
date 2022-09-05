package com.buimanhthanh.dao.impl;

import com.buimanhthanh.dao.ProductDao;
import com.buimanhthanh.entity.Category;
import com.buimanhthanh.entity.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Optional<Product> getProductById(Integer id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession()
                .createQuery("from Product as a where a.id =: i", Product.class)
                .setParameter("i",id)
                .getSingleResult());
    }

    @Override
    public Optional<List<Product>> getAllProduct() {
        return Optional.ofNullable(sessionFactory.getCurrentSession()
                .createQuery("from Product",Product.class)
                .getResultList());
    }

    @Override
    public Boolean saveOrUpdateProduct(Product product) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(product);
            return true;
        } catch (HibernateException e){
            System.out.println( "Error == add Product" + e.getMessage());
        }
        return false;
    }

    @Override
    public void deleteProduct(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class, id);
        if(product!=null)
            session.delete(product);
    }

    @Override
    public void deleteProduct(List<Integer> ids) {

        if(!ids.isEmpty())
            ids.forEach(this::deleteProduct);
    }
}
