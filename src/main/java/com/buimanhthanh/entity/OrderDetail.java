package com.buimanhthanh.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "order_detail", schema = "buimanhthanhecormmercespringmvc")
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		OrderDetail that = (OrderDetail) o;

		if (id != null ? !id.equals(that.id) : that.id != null)
			return false;
		if (price != null ? !price.equals(that.price) : that.price != null)
			return false;
		if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (price != null ? price.hashCode() : 0);
		result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
		return result;
	}

	public ProductDetail getProductDetailByProductId() {
		return productDetailByProductId;
	}

	public void setProductDetailByProductId(ProductDetail productDetailByProductId) {
		this.productDetailByProductId = productDetailByProductId;
	}

	public Order getOrderByOrderId() {
		return orderByOrderId;
	}

	public void setOrderByOrderId(Order orderByOrderId) {
		this.orderByOrderId = orderByOrderId;
	}
}
