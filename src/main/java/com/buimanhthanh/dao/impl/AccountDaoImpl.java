package com.buimanhthanh.dao.impl;

import com.buimanhthanh.dao.AccountDao;
import com.buimanhthanh.entity.Account;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Optional<Account> getAccountByUsername(String username) {
        return Optional.ofNullable(sessionFactory.getCurrentSession()
                .createQuery("from Account as a where a.username =: u",Account.class)
                .setParameter("u",username)
                .getSingleResult());
    }

    @Override
    public Optional<List<Account>> getAllAccount() {
        return Optional.ofNullable(sessionFactory.getCurrentSession()
                .createQuery("from Account",Account.class)
                .getResultList());
    }

    @Override
    public Boolean saveOrUpdateAccount(Account account) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(account);
            return true;
        } catch (HibernateException e){
            System.out.println( "Error == add Account" + e.getMessage());
        }
        return false;
    }

}
