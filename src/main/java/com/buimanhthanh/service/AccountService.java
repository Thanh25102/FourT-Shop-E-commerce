package com.buimanhthanh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.buimanhthanh.dto.AccountDTO;

public interface AccountService extends UserDetailsService{
    Optional<AccountDTO> getAccountByUsername(String username);
    
    Optional<AccountDTO> getAccountByEmail(String email);

    Optional<List<AccountDTO>> getAllAccount();

    Boolean saveOrUpdateAccount(AccountDTO accountDTO);

    Boolean registerAccount(AccountDTO accountDTO);
    
}
