package com.buimanhthanh.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartDetailDTO {
    private Integer id;
    private Integer productId;
    private Integer cartId;
    private Double price;
    private Integer quantity;

    private String productName;
    private String productImage;
    public CartDetailDTO(Integer id, Integer productId, Integer cartId, Double price, Integer quantity) {
        this.id = id;
        this.productId = productId;
        this.cartId = cartId;
        this.price = price;
        this.quantity = quantity;
    }

    public CartDetailDTO(Integer id, Integer productId, Integer cartId, Double price, Integer quantity, String productName, String productImage) {
        this.id = id;
        this.productId = productId;
        this.cartId = cartId;
        this.price = price;
        this.quantity = quantity;
        this.productName = productName;
        this.productImage = productImage;
    }
}
