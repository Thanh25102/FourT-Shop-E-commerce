package com.buimanhthanh.entity;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Basic
	@Column(name = "name", nullable = false, length = 55)
	private String name;

	@Basic
	@Column(name = "price", nullable = false, precision = 0)
	private Double price;

	@Basic
	@Column(name = "description", nullable = true, length = 255)
	private String description;

	@Basic
	@Column(name = "thumbnail", nullable = true, length = 55)
	private String thumbnail;

	@Basic
	@Column(name = "represent", nullable = true, length = 255)
	private String represent;

	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
	private Category categoryByCategoryId;
	
	@ManyToOne
	@JoinColumn(name = "discount_id", referencedColumnName = "id")
	private Discount discountByDiscountId;
	
	@OneToMany(mappedBy = "productByProductId", fetch = FetchType.LAZY,cascade = {
			CascadeType.REMOVE
	})
	private Collection<ProductDetail> productDetailsById;
}
