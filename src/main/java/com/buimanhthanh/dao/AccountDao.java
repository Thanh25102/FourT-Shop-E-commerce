package com.buimanhthanh.dao;

import com.buimanhthanh.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountDao {
    Optional<Account> getAccountByUsername(String username);

    Optional<List<Account>> getAllAccount();

    Boolean saveOrUpdateAccount(Account account);

}
