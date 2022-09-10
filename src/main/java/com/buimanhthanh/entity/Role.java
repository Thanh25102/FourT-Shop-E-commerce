package com.buimanhthanh.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Role implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic
	@Column(name = "authority", nullable = false, length = 64)
	@NotNull(message = "{null.err}")
	private String authority;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	@NotNull(message = "{null.err}")
	private Integer id;

	@OneToMany(mappedBy = "roleById")
	private Collection<Account> accountByRoleId;
	
	@OneToMany(mappedBy = "roleByRoleId")
	private Collection<Permission> permissionByRoleId;



	public Collection<Permission> getPermissionByRoleId() {
		return permissionByRoleId;
	}

	public void setPermissionByRoleId(Collection<Permission> permissionByRoleId) {
		this.permissionByRoleId = permissionByRoleId;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Collection<Account> getAccountByRoleId() {
		return accountByRoleId;
	}

	public void setAccountByRoleId(Collection<Account> accountByRoleId) {
		this.accountByRoleId = accountByRoleId;
	}
}
