package com.buimanhthanh.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.buimanhthanh.validation.PasswordConfirmMatch;

@Entity
@Table(name = "account")
@Data
@PasswordConfirmMatch
public class Account implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "username", nullable = false, length = 50)
	private String username;
	@Basic
	@Column(name = "password", nullable = false, length = 64)
	private String password;

	@Transient
	private String passwordConfirm;

	@Basic
	@Column(name = "enabled", nullable = false)
	private Boolean enabled4;
	@Basic
	@Column(name = "email", nullable = false, length = 100, unique = true)
	private String email;
	@Basic
	@Column(name = "phone", nullable = true, length = 20)
	private String phone;
	@Basic
	@Column(name = "full_name", nullable = false, length = 55)
	private String fullName;
	@Basic
	@Column(name = "address", nullable = true, length = 255)
	private String address;
	@Basic
	@Column(name = "rank_account", nullable = false, length = 55)
	private String rankAccount;

	@OneToMany(mappedBy = "accountByUsername",fetch = FetchType.EAGER)
	private Set<Cart> cartsByUsername;

	@OneToMany(mappedBy = "accountByUsername",fetch = FetchType.EAGER)
	private Set<Order> ordersByUsername;

	@ManyToOne
	@JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
	private Role roleById;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> auths = new HashSet<>();
		auths.add(new SimpleGrantedAuthority(roleById.getAuthority()));
		return auths;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled4;
	}

	@Override
	public String toString() {
		return "Account{" +
				"username='" + username + '\'' +
				", password='" + password + '\'' +
				", passwordConfirm='" + passwordConfirm + '\'' +
				", enabled4=" + enabled4 +
				", email='" + email + '\'' +
				", phone='" + phone + '\'' +
				", fullName='" + fullName + '\'' +
				", address='" + address + '\'' +
				", rankAccount='" + rankAccount + '\'' +
				", cartsByUsername=" + cartsByUsername +
				", ordersByUsername=" + ordersByUsername +
				", roleById=" + roleById +
				'}';
	}
}
