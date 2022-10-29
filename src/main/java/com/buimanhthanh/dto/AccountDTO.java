package com.buimanhthanh.dto;

import lombok.Data;

@Data
public class AccountDTO {
    private String username;
    private String password;
    private Byte enabled;
    private String email;
    private String phone;
    private String fullName;
    private String address;
    private String rankAccount;
    private Integer roleId;
}
