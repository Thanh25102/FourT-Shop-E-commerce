package com.buimanhthanh.dto;

import lombok.Data;

@Data
public class OrderDTO {
    private Integer id;
    private String username;
    private String orderStatus;
    private Integer ammount;
    private String paymentMethod;
    private java.sql.Timestamp createTime;
    private Integer discountCodeId;
}
