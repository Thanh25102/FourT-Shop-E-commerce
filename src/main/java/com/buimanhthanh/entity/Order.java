package com.buimanhthanh.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
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
	@OneToMany(mappedBy = "orderByOrderId")
	private Collection<OrderDetail> orderDetailsById;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getAmmount() {
		return ammount;
	}

	public void setAmmount(Integer ammount) {
		this.ammount = ammount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}


	public Account getAccountByUsername() {
		return accountByUsername;
	}

	public void setAccountByUsername(Account accountByUsername) {
		this.accountByUsername = accountByUsername;
	}

	public DiscountCode getDiscountCodeByDiscountCodeId() {
		return discountCodeByDiscountCodeId;
	}

	public void setDiscountCodeByDiscountCodeId(DiscountCode discountCodeByDiscountCodeId) {
		this.discountCodeByDiscountCodeId = discountCodeByDiscountCodeId;
	}

	public Collection<OrderDetail> getOrderDetailsById() {
		return orderDetailsById;
	}

	public void setOrderDetailsById(Collection<OrderDetail> orderDetailsById) {
		this.orderDetailsById = orderDetailsById;
	}
}
