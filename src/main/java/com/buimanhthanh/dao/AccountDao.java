package com.buimanhthanh.dao;

import com.buimanhthanh.dto.AccountDTO;
import com.buimanhthanh.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountDao {
    Optional<AccountDTO> getAccountByUsername(String username);

    Optional<AccountDTO> getAccountByEmail(String email);
    
    Optional<List<AccountDTO>> getAllAccount();

    Boolean saveOrUpdateAccount(Account account);

	Boolean registerAccount(Account account);

}
