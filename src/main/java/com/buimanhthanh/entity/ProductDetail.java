package com.buimanhthanh.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "product_detail", schema = "buimanhthanhecormmercespringmvc", catalog = "")
public class ProductDetail {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Basic
	@Column(name = "quantity", nullable = false)
	private Integer quantity;
	@Basic
	@Column(name = "description", nullable = false, length = 255)
	private String description;
	@Basic
	@Column(name = "image", nullable = true, length = 255)
	private String image;
	@OneToMany(mappedBy = "productDetailByProductId")
	private Collection<CartDetail> cartDetailsById;
	@OneToMany(mappedBy = "productDetailByProductId")
	private Collection<OrderDetail> orderDetailsById;
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
	private Product productByProductId;
	@ManyToOne
	@JoinColumn(name = "size_id", referencedColumnName = "id", nullable = false)
	private Size sizeBySizeId;
	@ManyToOne
	@JoinColumn(name = "color_id", referencedColumnName = "id", nullable = false)
	private Color colorByColorId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Collection<CartDetail> getCartDetailsById() {
		return cartDetailsById;
	}

	public void setCartDetailsById(Collection<CartDetail> cartDetailsById) {
		this.cartDetailsById = cartDetailsById;
	}

	public Collection<OrderDetail> getOrderDetailsById() {
		return orderDetailsById;
	}

	public void setOrderDetailsById(Collection<OrderDetail> orderDetailsById) {
		this.orderDetailsById = orderDetailsById;
	}

	public Product getProductByProductId() {
		return productByProductId;
	}

	public void setProductByProductId(Product productByProductId) {
		this.productByProductId = productByProductId;
	}

	public Size getSizeBySizeId() {
		return sizeBySizeId;
	}

	public void setSizeBySizeId(Size sizeBySizeId) {
		this.sizeBySizeId = sizeBySizeId;
	}

	public Color getColorByColorId() {
		return colorByColorId;
	}

	public void setColorByColorId(Color colorByColorId) {
		this.colorByColorId = colorByColorId;
	}
}
