package com.buimanhthanh.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Permission implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "access_id", referencedColumnName = "id", nullable = false)
	private Access accessByAccessId;

	@Id
	@ManyToOne
	@JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
	private Role roleByRoleId;

	public Access getAccessByAccessId() {
		return accessByAccessId;
	}

	public void setAccessByAccessId(Access accessByAccessId) {
		this.accessByAccessId = accessByAccessId;
	}

	public Role getRoleByRoleId() {
		return roleByRoleId;
	}

	public void setRoleByRoleId(Role roleByRoleId) {
		this.roleByRoleId = roleByRoleId;
	}
}
