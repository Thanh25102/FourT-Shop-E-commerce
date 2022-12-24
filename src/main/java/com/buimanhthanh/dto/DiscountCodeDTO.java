package com.buimanhthanh.dto;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscountCodeDTO {
    private Integer id;
    private String code;
    private Integer salePercent;
    private Long saleMoney;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private java.util.Date startDay;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private java.util.Date endDay;
    private Long maxDiscount;
    private String description;
}
