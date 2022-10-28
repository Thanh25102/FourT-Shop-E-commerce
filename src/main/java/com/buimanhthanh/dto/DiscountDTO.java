package com.buimanhthanh.dto;

import lombok.Data;

@Data
public class DiscountDTO {
    private Integer id;
    private Integer salePercent;
    private java.sql.Date startDay;
    private java.sql.Date endDay;
    private String description;
}
