package com.buimanhthanh.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Permission implements Serializable{

	@Id
	@ManyToOne
	@JoinColumn(name = "access_id", referencedColumnName = "id", nullable = false)
	private Access accessByAccessId;

	@Id
	@ManyToOne
	@JoinColumn(name = "authority", referencedColumnName = "authority", nullable = false)
	private Role roleByAuthority;

	public Access getAccessByAccessId() {
		return accessByAccessId;
	}

	public void setAccessByAccessId(Access accessByAccessId) {
		this.accessByAccessId = accessByAccessId;
	}

	public Role getRoleByAuthority() {
		return roleByAuthority;
	}

	public void setRoleByAuthority(Role roleByAuthority) {
		this.roleByAuthority = roleByAuthority;
	}
}
