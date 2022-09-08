package com.buimanhthanh.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buimanhthanh.dao.AccountDao;
import com.buimanhthanh.entity.Account;

@Repository
public class AccountDaoImpl implements AccountDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Optional<Account> getAccountByUsername(String username) {
//        return Optional.ofNullable(sessionFactory.getCurrentSession()
//                .createQuery("from Account as a where a.username =: u",Account.class)
//                .setParameter("u",username)
//                .getSingleResult()).orElse();
		return sessionFactory.getCurrentSession().createQuery("from Account as a where a.username =: u", Account.class)
						.setParameter("u", username).getResultList().stream().findFirst();
				
	}

    
    @Override
	public Optional<Account> getAccountByEmail(String email){
		return sessionFactory.getCurrentSession().createQuery("from Account as a where a.email =: u", Account.class)
						.setParameter("u", email).getResultList().stream().findFirst();
				
	}

	@Override
	public Optional<List<Account>> getAllAccount() {
		return Optional.ofNullable(sessionFactory.getCurrentSession().createQuery("from Account", Account.class).getResultList());
	}

	@Override
	public Boolean saveOrUpdateAccount(Account account) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(account);
			return true;
		} catch (HibernateException e) {
			System.out.println("Error == add Account" + e.getMessage());
		}
		return false;
	}

	@Override
	public Boolean registerAccount(Account account) {
		try {
			sessionFactory.getCurrentSession().save(account);
			return true;
		} catch (Exception e) {
			System.out.println("Error == add Account" + e.getMessage());
		}
		return false;
	}

}
