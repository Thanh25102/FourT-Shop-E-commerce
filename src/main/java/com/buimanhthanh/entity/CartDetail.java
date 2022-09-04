package com.buimanhthanh.entity;

import javax.persistence.*;

@Entity
@Table(name = "cart_detail", schema = "buimanhthanhecormmercespringmvc", catalog = "")
public class CartDetail {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Basic
	@Column(name = "price", nullable = false, precision = 0)
	private Double price;
	@Basic
	@Column(name = "quantity", nullable = false)
	private Integer quantity;
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
	private ProductDetail productDetailByProductId;
	@ManyToOne
	@JoinColumn(name = "cart_id", referencedColumnName = "id", nullable = false)
	private Cart cartByCartId;

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

		CartDetail that = (CartDetail) o;

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

	public Cart getCartByCartId() {
		return cartByCartId;
	}

	public void setCartByCartId(Cart cartByCartId) {
		this.cartByCartId = cartByCartId;
	}
}
