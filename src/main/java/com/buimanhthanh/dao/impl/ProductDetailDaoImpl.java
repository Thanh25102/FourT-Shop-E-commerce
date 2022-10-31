package com.buimanhthanh.dao.impl;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.dto.ProductDetailDTO;
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
	public Optional<ProductDetailDTO> getProductDetailById(Integer id) {
		return sessionFactory.getCurrentSession()
				.createQuery("select new com.buimanhthanh.dto.ProductDetailDTO(a.id,a.productByProductId.id,a.sizeBySizeId.id,a.colorByColorId.id,a.quantity,a.description,a.image) from ProductDetail as a where a.id =: i", ProductDetailDTO.class).setParameter("i", id)
				.getResultList().stream().findFirst();
	}

	@Override
	public Optional<List<ProductDetailDTO>> getAllProductDetail() {
		return Optional.ofNullable(sessionFactory.getCurrentSession()
				.createQuery("select new com.buimanhthanh.dto.ProductDetailDTO(a.id,a.productByProductId.id,a.sizeBySizeId.id,a.colorByColorId.id,a.quantity,a.description,a.image) from ProductDetail a", ProductDetailDTO.class).getResultList());
	}

	@Override
	public Optional<List<ProductDetailDTO>> getProductDetailByProductId(Integer id) {
		return Optional.ofNullable(sessionFactory.getCurrentSession()
				.createQuery("select new com.buimanhthanh.dto.ProductDetailDTO(a.id,a.productByProductId.id,a.sizeBySizeId.id,a.colorByColorId.id,a.quantity,a.description,a.image) from ProductDetail a where a.productByProductId.id =: i", ProductDetailDTO.class)
				.setParameter("i", id)
				.getResultList());
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
