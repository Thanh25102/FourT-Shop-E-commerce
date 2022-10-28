package com.buimanhthanh.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cart_detail", schema = "buimanhthanhecormmercespringmvc", catalog = "")
@Data
public class CartDetail {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	@NotNull(message = "{null.err}")
	private Integer id;
	@Basic
	@Column(name = "price", nullable = false, precision = 0)
	@NotNull(message = "{null.err}")
	private Double price;
	@Basic
	@Column(name = "quantity", nullable = false)
	@NotNull(message = "{null.err}")
	private Integer quantity;
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
	@NotNull(message = "{null.err}")
	private ProductDetail productDetailByProductId;
	@ManyToOne
	@JoinColumn(name = "cart_id", referencedColumnName = "id", nullable = false)
	@NotNull(message = "{null.err}")
	private Cart cartByCartId;
}
