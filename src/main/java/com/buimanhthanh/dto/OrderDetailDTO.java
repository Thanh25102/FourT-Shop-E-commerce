package com.buimanhthanh.dto;

import lombok.Data;

@Data
public class OrderDetailDTO {
    private Integer id;
    private Integer productId;
    private Integer orderId;
    private Double price;
    private Integer quantity;
}
