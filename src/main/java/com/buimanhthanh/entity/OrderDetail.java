package com.buimanhthanh.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "order_detail", schema = "buimanhthanhecormmercespringmvc")
@Data
public class OrderDetail {
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
	@JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
	@NotNull(message = "{null.err}")
	private Order orderByOrderId;
}
