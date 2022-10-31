package com.buimanhthanh.dto;

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
    private java.util.Date startDay;
    private java.util.Date endDay;
    private Long maxDiscount;
    private String description;
}
