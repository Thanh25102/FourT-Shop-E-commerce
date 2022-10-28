package com.buimanhthanh.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Integer id;
    private String name;
    private Double price;
    private Integer categoryId;
    private String description;
    private String thumbnail;
    private String represent;
    private Integer discountId;
}
