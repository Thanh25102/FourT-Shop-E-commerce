package com.buimanhthanh.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "role")
@Data
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
}
