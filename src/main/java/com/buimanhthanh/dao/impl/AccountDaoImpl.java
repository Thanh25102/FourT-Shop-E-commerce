package com.buimanhthanh.dao.impl;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.dto.AccountDTO;
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
	public Optional<AccountDTO> getAccountByUsername(String username) {
		return sessionFactory.getCurrentSession()
						.createQuery("select new com.buimanhthanh.dto.AccountDTO(a.username,a.password,a.password,a.enabled4,a.email,a.phone,a.fullName,a.address,a.rankAccount,a.roleById.id) from Account a where a.username =: u", AccountDTO.class)
						.setParameter("u", username).getResultList().stream().findFirst();
				
	}

    
    @Override
	public Optional<AccountDTO> getAccountByEmail(String email){
		return sessionFactory.getCurrentSession()
						.createQuery("select new com.buimanhthanh.dto.AccountDTO(a.username,a.password,a.password,a.enabled4,a.email,a.phone,a.fullName,a.address,a.rankAccount,a.roleById.id) from Account as a where a.email =: u", AccountDTO.class)
						.setParameter("u", email).getResultList().stream().findFirst();
				
	}

	@Override
	public Optional<List<AccountDTO>> getAllAccount() {
		return Optional.ofNullable(sessionFactory.getCurrentSession()
							.createQuery(" select new com.buimanhthanh.dto.AccountDTO(a.username,a.password,a.password,a.enabled4,a.email,a.phone,a.fullName,a.address,a.rankAccount,a.roleById.id) from Account a", AccountDTO.class)
							.getResultList());
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
