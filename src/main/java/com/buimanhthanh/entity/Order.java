package com.buimanhthanh.entity;

import java.sql.Timestamp;
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
@Table(name = "order_")
@Data
public class Order {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	@NotNull(message = "{null.err}")
	private Integer id;
	@Basic
	@Column(name = "order_status", nullable = false, length = 20)
	@NotNull(message = "{null.err}")
	private String orderStatus;
	@Basic
	@Column(name = "ammount", nullable = false)
	@NotNull(message = "{null.err}")
	private Integer ammount;
	@Basic
	@Column(name = "payment_method", nullable = false, length = 50)
	@NotNull(message = "{null.err}")
	@Length(max = 50,message = "{access.code.err}")
	private String paymentMethod;
	@Basic
	@Column(name = "create_time", nullable = false)
	@NotNull(message = "{null.err}")
	private Timestamp createTime;
	@ManyToOne
	@JoinColumn(name = "username", referencedColumnName = "username", nullable = false)
	@NotNull(message = "{null.err}")
	private Account accountByUsername;
	@ManyToOne
	@JoinColumn(name = "discount_code_id", referencedColumnName = "id")
	private DiscountCode discountCodeByDiscountCodeId;
	@OneToMany(mappedBy = "orderByOrderId",fetch = FetchType.EAGER)
	private Set<OrderDetail> orderDetailsById;
}
