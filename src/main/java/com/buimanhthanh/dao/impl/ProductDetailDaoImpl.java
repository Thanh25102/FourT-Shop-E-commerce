package com.buimanhthanh.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buimanhthanh.dao.ProductDetailDao;
import com.buimanhthanh.entity.ProductDetail;

@Repository
public class ProductDetailDaoImpl implements ProductDetailDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Optional<ProductDetail> getProductDetailById(Integer id) {
		return sessionFactory.getCurrentSession()
				.createQuery("from ProductDetail as a where a.id =: i", ProductDetail.class).setParameter("i", id)
				.getResultList().stream().findFirst();
	}

	@Override
	public Optional<List<ProductDetail>> getAllProductDetail() {
		return Optional.ofNullable(sessionFactory.getCurrentSession()
				.createQuery("from ProductDetail", ProductDetail.class).getResultList());
	}

	@Override
	public Boolean saveOrUpdateProductDetail(ProductDetail productDetail) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(productDetail);
			return true;
		} catch (HibernateException e) {
			System.out.println("Error == add Product Detail" + e.getMessage());
		}
		return false;
	}

	@Override
	public void deleteProductDetail(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		ProductDetail productDetail = session.get(ProductDetail.class, id);
		if (productDetail != null)
			session.delete(productDetail);
	}

	@Override
	public void deleteProductDetail(List<Integer> ids) {
		if (!ids.isEmpty())
			ids.forEach(this::deleteProductDetail);
	}

}
