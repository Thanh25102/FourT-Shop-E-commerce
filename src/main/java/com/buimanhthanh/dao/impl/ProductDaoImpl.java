package com.buimanhthanh.dao.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buimanhthanh.dao.ProductDao;
import com.buimanhthanh.dto.PriceRange;
import com.buimanhthanh.dto.ProductDTO;
import com.buimanhthanh.entity.Product;
import com.buimanhthanh.enumration.SortType;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Optional<ProductDTO> getProductById(Integer id) {
		return sessionFactory.getCurrentSession().createQuery(
				"select new com.buimanhthanh.dto.ProductDTO(p.id,p.name,p.price,p.categoryByCategoryId.id,p.description,p.thumbnail,p.represent,p.discountByDiscountId.id) from Product as p where p.id =: i",
				ProductDTO.class).setParameter("i", id).getResultList().stream().findFirst();
	}

	@Override
	public Optional<List<ProductDTO>> getAllProduct() {
		return Optional.ofNullable(sessionFactory.getCurrentSession().createQuery(
				"select new com.buimanhthanh.dto.ProductDTO(p.id,p.name,p.price,p.categoryByCategoryId.id,p.description,p.thumbnail,p.represent,p.discountByDiscountId.id) from Product p",
				ProductDTO.class).getResultList());
	}

	@Override
	public Optional<List<ProductDTO>> getAllProduct(int page, int limit) {
		return Optional.ofNullable(sessionFactory.getCurrentSession().createQuery(
				"select new com.buimanhthanh.dto.ProductDTO(p.id,p.name,p.price,p.categoryByCategoryId.id,p.description,p.thumbnail,p.represent,p.discountByDiscountId.id) from Product p",
				ProductDTO.class).setFirstResult((page - 1) * limit).setMaxResults(limit).getResultList());
	}

	@Override
	public Boolean saveOrUpdateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		} catch (HibernateException e) {
			System.out.println("Error == add Product" + e.getMessage());
		}
		return false;
	}

	@Override
	public void deleteProduct(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = session.get(Product.class, id);
		if (product != null)
			session.delete(product);
	}

	@Override
	public void deleteProduct(List<Integer> ids) {

		if (!ids.isEmpty())
			ids.forEach(this::deleteProduct);
	}

	@Override
	public Optional<List<ProductDTO>> getAllProduct(int page, int limit, int categoryId, String orderBy,
			SortType sortType, PriceRange priceRange) {
		Field[] properties = ProductDTO.class.getDeclaredFields();
		List<String> propertyNames = new ArrayList<>();
		for (Field field : properties) {
			propertyNames.add(field.getName());
		}
		
		StringBuilder sql = new StringBuilder(
				"select new com.buimanhthanh.dto.ProductDTO(p.id,p.name,p.price,p.categoryByCategoryId.id,p.description,p.thumbnail,p.represent,p.discountByDiscountId.id) from Product p where 1=1");
		if (categoryId != 0) {
			sql.append(" and p.categoryByCategoryId.id = " + categoryId);
		}
		if (priceRange != null) {
			sql.append(" and p.price >= " + priceRange.getStart() + " and p.price <= " + priceRange.getEnd());
		}
		if (!orderBy.isEmpty() && propertyNames.contains(orderBy)) {
			sql.append(" order by p." + orderBy);
		}
		if (!orderBy.isEmpty() && propertyNames.contains(orderBy)) {
			sql.append(" " + sortType.getValue());
		}
		System.out.println(sql.toString());
		return Optional.ofNullable(sessionFactory.getCurrentSession().createQuery(sql.toString(), ProductDTO.class)
				.setFirstResult((page - 1) * limit).setMaxResults(limit).getResultList());
	}

	@Override
	public Long getCountProductFormCategory(Integer id) {
		return sessionFactory.getCurrentSession().createQuery(
				"select count(p) from Product p where p.categoryByCategoryId.id =: i",Long.class)
				.setParameter("i", id)
				.getSingleResult();
	}

	@Override
	public Long getCountProductFormCategory() {
		return sessionFactory.getCurrentSession().createQuery(
				"select count(p) from Product p",Long.class)
				.getSingleResult();
	}
}
