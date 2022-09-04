package com.buimanhthanh.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
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
	@Column(name = "repesent", nullable = true, length = 255)
	private String repesent;
	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
	private Category categoryByCategoryId;
	@ManyToOne
	@JoinColumn(name = "discount_id", referencedColumnName = "id")
	private Discount discountByDiscountId;
	@OneToMany(mappedBy = "productByProductId")
	private Collection<ProductDetail> productDetailsById;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getRepesent() {
		return repesent;
	}

	public void setRepesent(String repesent) {
		this.repesent = repesent;
	}

	public Category getCategoryByCategoryId() {
		return categoryByCategoryId;
	}

	public void setCategoryByCategoryId(Category categoryByCategoryId) {
		this.categoryByCategoryId = categoryByCategoryId;
	}

	public Discount getDiscountByDiscountId() {
		return discountByDiscountId;
	}

	public void setDiscountByDiscountId(Discount discountByDiscountId) {
		this.discountByDiscountId = discountByDiscountId;
	}

	public Collection<ProductDetail> getProductDetailsById() {
		return productDetailsById;
	}

	public void setProductDetailsById(Collection<ProductDetail> productDetailsById) {
		this.productDetailsById = productDetailsById;
	}
}
