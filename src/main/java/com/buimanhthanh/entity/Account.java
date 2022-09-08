package com.buimanhthanh.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.buimanhthanh.validation.PasswordConfirmMatch;
import com.buimanhthanh.validation.UsernameExist;

@Entity
@PasswordConfirmMatch
public class Account implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@UsernameExist
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
	@Column(name = "email", nullable = false, length = 100,unique = true)
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
	@OneToMany(mappedBy = "accountByUsername")
	private Collection<Cart> cartsByUsername;
	@OneToMany(mappedBy = "accountByUsername")
	private Collection<Order> ordersByUsername;

	@ManyToOne
	@JoinColumn(name = "role_id",referencedColumnName = "id",nullable = false)
	private Role roleById;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRankAccount() {
		return rankAccount;
	}

	public void setRankAccount(String rankAccount) {
		this.rankAccount = rankAccount;
	}

	public Collection<Cart> getCartsByUsername() {
		return cartsByUsername;
	}

	public void setCartsByUsername(Collection<Cart> cartsByUsername) {
		this.cartsByUsername = cartsByUsername;
	}

	public Collection<Order> getOrdersByUsername() {
		return ordersByUsername;
	}

	public void setOrdersByUsername(Collection<Order> ordersByUsername) {
		this.ordersByUsername = ordersByUsername;
	}

	public Role getRoleById() {
		return roleById;
	}

	public void setRoleById(Role roleById) {
		this.roleById = roleById;
	}

	
	
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public Boolean getEnabled4() {
		return enabled4;
	}

	public void setEnabled4(Boolean enabled4) {
		this.enabled4 = enabled4;
	}

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
}
