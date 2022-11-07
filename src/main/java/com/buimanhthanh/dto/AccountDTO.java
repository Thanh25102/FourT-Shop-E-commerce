package com.buimanhthanh.dto;

import com.buimanhthanh.validation.PasswordConfirmMatch;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
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
    private String avatar;
    private MultipartFile avatarFile;
    private Integer roleId;

    public AccountDTO(String username, String password, String passwordConfirm, Boolean enabled, String email, String phone, String fullName, String address, String rankAccount, String avatar, Integer roleId) {
        this.username = username;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.enabled = enabled;
        this.email = email;
        this.phone = phone;
        this.fullName = fullName;
        this.address = address;
        this.rankAccount = rankAccount;
        this.avatar = avatar;
        this.roleId = roleId;
    }
}
