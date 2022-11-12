package com.buimanhthanh.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDTO {
	private Integer id;
	private String username;
	private String orderStatus;
	private Integer ammount;
	private String paymentMethod;
	private Date createTime;
	private Integer discountCodeId;
	private List<OrderDetailDTO> orderDetailDTOs;

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

}
