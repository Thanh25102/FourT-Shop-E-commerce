package com.buimanhthanh.dto;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountDTO {
    private Integer id;
    private Integer salePercent;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private java.util.Date startDay;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private java.util.Date endDay;
    private String description;
}
