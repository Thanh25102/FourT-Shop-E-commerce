package com.buimanhthanh.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Table(name = "product")
@Data
public class Product {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	@NotNull(message = "{null.err}")
	private Integer id;
	@Basic
	@Column(name = "name", nullable = false, length = 55)
	@NotNull(message = "{null.err}")
	private String name;
	@Basic
	@Column(name = "price", nullable = false, precision = 0)
	@NotNull(message = "{null.err}")
	private Double price;
	@Basic
	@Column(name = "description", nullable = true, length = 255)
	private String description;
	@Basic
	@Column(name = "thumbnail", nullable = true, length = 55)
	private String thumbnail;
	@Basic
	@Column(name = "represent", nullable = true, length = 255)
	@Length(max = 255, message = "{access.description.err}")
	private String represent;
	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
	@NotNull(message = "{null.err}")
	private Category categoryByCategoryId;
	
	@ManyToOne
	@JoinColumn(name = "discount_id", referencedColumnName = "id")
	private Discount discountByDiscountId;
	
	@OneToMany(mappedBy = "productByProductId", fetch = FetchType.EAGER,cascade = {
			CascadeType.REMOVE
	})
	private Collection<ProductDetail> productDetailsById;
}
