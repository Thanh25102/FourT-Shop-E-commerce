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

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "product_detail", schema = "buimanhthanhecormmercespringmvc")
@Data
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
}
