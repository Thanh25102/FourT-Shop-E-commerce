package com.buimanhthanh.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountDTO {
    private Integer id;
    private Integer salePercent;
    private java.util.Date startDay;
    private java.util.Date endDay;
    private String description;
}
