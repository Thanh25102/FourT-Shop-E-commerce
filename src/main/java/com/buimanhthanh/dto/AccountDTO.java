package com.buimanhthanh.dto;

import com.buimanhthanh.validation.PasswordConfirmMatch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@PasswordConfirmMatch
public class AccountDTO {
    private String username;
    private String password;
    private String passwordConfirm;
    private Boolean enabled;
    private String email;
    private String phone;
    private String fullName;
    private String address;
    private String rankAccount;
    private Integer roleId;
}
