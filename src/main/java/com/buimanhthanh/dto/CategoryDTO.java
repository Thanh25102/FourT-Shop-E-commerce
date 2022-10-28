package com.buimanhthanh.dto;

import lombok.Data;

@Data
public class CategoryDTO {
    private Integer id;
    private String name;
    private String code;
    private String thumbnail;
    private String description;
    private String logo;
}
