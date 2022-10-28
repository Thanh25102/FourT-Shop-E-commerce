package com.buimanhthanh.dto;

import lombok.Data;

@Data
public class DiscountCodeDTO {
    private Integer id;
    private String code;
    private Integer salePercent;
    private Long saleMoney;
    private java.sql.Date startDay;
    private java.sql.Date endDay;
    private Long maxDiscount;
    private String description;
}
