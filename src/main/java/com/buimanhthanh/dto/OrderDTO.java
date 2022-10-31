package com.buimanhthanh.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Integer id;
    private String username;
    private String orderStatus;
    private Integer ammount;
    private String paymentMethod;
    private Date createTime;
    private Integer discountCodeId;
}
