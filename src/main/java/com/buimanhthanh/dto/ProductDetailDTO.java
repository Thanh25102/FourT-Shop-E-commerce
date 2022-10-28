package com.buimanhthanh.dto;

import lombok.Data;

@Data
public class ProductDetailDTO {
    private Integer id;
    private Integer productId;
    private Integer sizeId;
    private Integer colorId;
    private Integer quantity;
    private String description;
    private String image;
}
