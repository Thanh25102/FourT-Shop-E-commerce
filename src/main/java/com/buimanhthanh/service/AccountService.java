package com.buimanhthanh.service;

import com.buimanhthanh.entity.Account;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends UserDetailsService{
    Optional<Account> getAccountByUsername(String username);
    
    Optional<Account> getAccountByEmail(String email);

    Optional<List<Account>> getAllAccount();

    Boolean saveOrUpdateAccount(Account account);

    Boolean registerAccount(Account account);
    
}
