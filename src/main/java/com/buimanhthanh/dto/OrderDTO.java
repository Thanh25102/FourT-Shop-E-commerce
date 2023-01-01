package com.buimanhthanh.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
	private Integer id;
	private String username;
	private String orderStatus;
	private Integer ammount;
	private String paymentMethod;
	private Date createTime;
	private String phone;
	private String shipingAddress;
	private String city;
	private Double sumMoney;

	private Integer discountCodeId;
	private List<OrderDetailDTO> orderDetailDTOs;
	private String discountCode;

	public OrderDTO(Integer id, String username, String orderStatus, Integer ammount, String paymentMethod,
			Date createTime, Integer discountCodeId) {
		this.id = id;
		this.username = username;
		this.orderStatus = orderStatus;
		this.ammount = ammount;
		this.paymentMethod = paymentMethod;
		this.createTime = createTime;
		this.discountCodeId = discountCodeId;
	}

	public OrderDTO(Integer id, String username, String orderStatus, Integer ammount, String paymentMethod,
			Date createTime, String phone, String shipingAddress, String city, Integer discountCodeId) {
		this.id = id;
		this.username = username;
		this.orderStatus = orderStatus;
		this.ammount = ammount;
		this.paymentMethod = paymentMethod;
		this.createTime = createTime;
		this.phone = phone;
		this.shipingAddress = shipingAddress;
		this.city = city;
		this.discountCodeId = discountCodeId;
	}

	public OrderDTO(Integer id, String username, String orderStatus, Integer ammount, String paymentMethod,
			Date createTime, String phone, String shipingAddress, String city, Integer discountCodeId,
			Double sumMoney) {
		this.id = id;
		this.username = username;
		this.orderStatus = orderStatus;
		this.ammount = ammount;
		this.paymentMethod = paymentMethod;
		this.createTime = createTime;
		this.phone = phone;
		this.shipingAddress = shipingAddress;
		this.city = city;
		this.discountCodeId = discountCodeId;
		this.sumMoney = sumMoney;
	}

	public OrderDTO(Integer id, String username, String orderStatus, Integer ammount, String paymentMethod,
			Date createTime, String phone, String shipingAddress, String city, Integer discountCodeId, Double sumMoney,
			String discountCode) {
		this.id = id;
		this.username = username;
		this.orderStatus = orderStatus;
		this.ammount = ammount;
		this.paymentMethod = paymentMethod;
		this.createTime = createTime;
		this.phone = phone;
		this.shipingAddress = shipingAddress;
		this.city = city;
		this.discountCodeId = discountCodeId;
		this.sumMoney = sumMoney;
		this.discountCode = discountCode;
	}

}
