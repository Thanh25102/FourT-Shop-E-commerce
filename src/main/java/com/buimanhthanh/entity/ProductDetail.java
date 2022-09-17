package com.buimanhthanh.entity;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "product_detail", schema = "buimanhthanhecormmercespringmvc", catalog = "")
public class ProductDetail {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	@NotNull(message = "{null.err}")
	private Integer id;

	@Basic
	@Column(name = "quantity", nullable = false)
	@NotNull(message = "{null.err}")
	private Integer quantity;
	@Basic
	@Column(name = "description", nullable = false, length = 255)
	@Length(max = 255, message = "{access.description.err}")
	@NotNull(message = "{null.err}")
	private String description;
	@Basic
	@Column(name = "image", nullable = true, length = 255)
	@Length(max = 255, message = "{access.description.err}")
	private String image;
	@OneToMany(mappedBy = "productDetailByProductId",fetch = FetchType.EAGER)
	private Collection<CartDetail> cartDetailsById;
	@OneToMany(mappedBy = "productDetailByProductId",fetch = FetchType.EAGER)
	private Set<OrderDetail> orderDetailsById;
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
	@NotNull(message = "{null.err}")
	private Product productByProductId;
	@ManyToOne
	@JoinColumn(name = "size_id", referencedColumnName = "id", nullable = false)
	@NotNull(message = "{null.err}")
	private Size sizeBySizeId;
	@ManyToOne
	@JoinColumn(name = "color_id", referencedColumnName = "id", nullable = false)
	@NotNull(message = "{null.err}")
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

	public Set<OrderDetail> getOrderDetailsById() {
		return orderDetailsById;
	}

	public void setOrderDetailsById(Set<OrderDetail> orderDetailsById) {
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

	@Override
	public String toString() {
		return "ProductDetail [id=" + id + ", quantity=" + quantity + ", description=" + description + ", image="
				+ image + ", cartDetailsById=" + cartDetailsById + ", orderDetailsById=" + orderDetailsById
				+ ", productByProductId=" + productByProductId + ", sizeBySizeId=" + sizeBySizeId + ", colorByColorId="
				+ colorByColorId + "]";
	}
}
