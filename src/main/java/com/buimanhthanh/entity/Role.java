package com.buimanhthanh.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Role implements Serializable{
	@Basic
	@Column(name = "authority", nullable = false, length = 64)
	private String authority;
	@Id
	@OneToOne
	@JoinColumn(name = "username", referencedColumnName = "username", nullable = false)
	private Account accountByUsername;

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Account getAccountByUsername() {
		return accountByUsername;
	}

	public void setAccountByUsername(Account accountByUsername) {
		this.accountByUsername = accountByUsername;
	}
}
