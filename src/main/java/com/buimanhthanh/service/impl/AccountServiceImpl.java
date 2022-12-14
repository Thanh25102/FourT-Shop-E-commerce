package com.buimanhthanh.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buimanhthanh.dao.AccountDao;
import com.buimanhthanh.dto.AccountDTO;
import com.buimanhthanh.dto.RoleDTO;
import com.buimanhthanh.entity.Account;
import com.buimanhthanh.entity.Role;
import com.buimanhthanh.service.AccountService;
import com.buimanhthanh.service.RoleService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service("userDetailService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private RoleService roleService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private Cloudinary cloudinary;

	@Override
	@Transactional
	public Optional<AccountDTO> getAccountByUsername(String username) {
		return accountDao.getAccountByUsername(username);
	}

	@Override
	@Transactional
	public Optional<AccountDTO> getAccountByEmail(String email) {
		return accountDao.getAccountByEmail(email);
	}

	@Override
	@Transactional
	public Optional<List<AccountDTO>> getAllAccount() {
		return accountDao.getAllAccount();
	}

	@Override
	@Transactional
	public Boolean saveOrUpdateAccount(AccountDTO accountDTO) {
		Account account = new Account(accountDTO.getUsername(), accountDTO.getPassword(), accountDTO.getEnabled(),
				accountDTO.getEmail(), accountDTO.getPhone(), accountDTO.getFullName(), accountDTO.getAddress(),
				accountDTO.getRankAccount(), accountDTO.getAvatar(), null, null, null);
		Role role = new Role();
		role.setId(accountDTO.getRoleId());
		account.setRoleById(role);
		return accountDao.saveOrUpdateAccount(account);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<AccountDTO> account = this.getAccountByUsername(username);
		if (account.isEmpty())
			throw new UsernameNotFoundException("ncc");
		AccountDTO accountDTO = account.get();
		Account account1 = new Account(accountDTO.getUsername(), accountDTO.getPassword(), accountDTO.getEnabled(),
				accountDTO.getEmail(), accountDTO.getPhone(), accountDTO.getFullName(), accountDTO.getAddress(),
				accountDTO.getRankAccount(), accountDTO.getAvatar(), null, null, null);

		RoleDTO roleDTO = roleService.getRoleById(accountDTO.getRoleId()).get();
		Role role = new Role(roleDTO.getAuthority(), roleDTO.getId(), null, null);

		account1.setRoleById(role);
		return account1;
	}

	@Override
	@Transactional
	public Boolean registerAccount(AccountDTO accountDTO) {
		Account account = new Account(accountDTO.getUsername(), accountDTO.getPassword(), true, accountDTO.getEmail(),
				accountDTO.getPhone(), accountDTO.getFullName(), accountDTO.getAddress(), "MEMBER",
				accountDTO.getAvatar(), null, null, null);

		RoleDTO roleDTO = roleService.getRoleByAuthority("CUSTOMER").get();
		Role role = new Role(roleDTO.getAuthority(), roleDTO.getId(), null, null);

		account.setRoleById(role);
		String newPassword = passwordEncoder.encode(account.getPassword());
		account.setPassword(newPassword);

		try {
			@SuppressWarnings("rawtypes")
			Map result = cloudinary.uploader().upload(accountDTO.getAvatarFile().getBytes(),
					ObjectUtils.asMap("resource_type", "auto"));
			accountDTO.setAvatar((String) result.get("secure_url"));
			account.setAvatar(accountDTO.getAvatar());
			return accountDao.registerAccount(account);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
