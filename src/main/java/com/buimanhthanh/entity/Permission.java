package com.buimanhthanh.entity;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "permission")
@Data
public class Permission implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "access_id", referencedColumnName = "id", nullable = false)
	@NotNull(message = "{null.err}")
	private Access accessByAccessId;

	@Id
	@ManyToOne
	@JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
	@NotNull(message = "{null.err}")
	private Role roleByRoleId;

}
