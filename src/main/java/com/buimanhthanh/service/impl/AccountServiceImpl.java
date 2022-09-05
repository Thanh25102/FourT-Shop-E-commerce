package com.buimanhthanh.service.impl;

import com.buimanhthanh.dao.AccountDao;
import com.buimanhthanh.entity.Account;
import com.buimanhthanh.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    @Transactional
    public Optional<Account> getAccountByUsername(String username) {
        return accountDao.getAccountByUsername(username);
    }

    @Override
    @Transactional
    public Optional<List<Account>> getAllAccount() {
        return accountDao.getAllAccount();
    }

    @Override
    @Transactional
    public Boolean saveOrUpdateAccount(Account account) {
        return accountDao.saveOrUpdateAccount(account);
    }
}
