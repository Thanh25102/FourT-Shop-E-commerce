package com.buimanhthanh.dto;

import lombok.Data;

@Data
public class CartDetailDTO {
    private Integer id;
    private Integer productId;
    private Integer cartId;
    private Double price;
    private Integer quantity;
}
