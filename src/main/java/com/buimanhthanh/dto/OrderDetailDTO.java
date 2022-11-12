package com.buimanhthanh.dto;

import lombok.Data;

@Data
public class OrderDetailDTO {
    private Integer id;
    private Integer productId;
    private Integer orderId;
    private Double price;
    private Integer quantity;
    
    private String productName;
    
	public OrderDetailDTO(Integer id, Integer productId, Integer orderId, Double price, Integer quantity) {
		this.id = id;
		this.productId = productId;
		this.orderId = orderId;
		this.price = price;
		this.quantity = quantity;
	}

	public OrderDetailDTO(Integer id, Integer productId, Integer orderId, Double price, Integer quantity,
			String productName) {
		this.id = id;
		this.productId = productId;
		this.orderId = orderId;
		this.price = price;
		this.quantity = quantity;
		this.productName = productName;
	}
    
    
}
