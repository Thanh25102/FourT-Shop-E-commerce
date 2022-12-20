package com.buimanhthanh.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "discount_code")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountCode {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	private Integer id;
	@Basic
	@Column(name = "code", nullable = false, length = 50)
	private String code;
	@Basic
	@Column(name = "sale_percent", nullable = false)
	private Integer salePercent;
	@Basic
	@Column(name = "sale_money", nullable = false)
	private Long saleMoney;
	@Basic
	@Column(name = "start_day", nullable = false)
	private Date startDay;
	@Basic
	@Column(name = "end_day", nullable = false)
	private Date endDay;
	@Basic
	@Column(name = "max_discount", nullable = false)
	private Long maxDiscount;
	@Basic
	@Column(name = "description", nullable = true, length = 255)
	private String description;
	@OneToMany(mappedBy = "discountCodeByDiscountCodeId")
	private Collection<Order> ordersById;
}
