package com.buimanhthanh.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Account {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "username", nullable = false, length = 50)
	private String username;
	@Basic
	@Column(name = "password", nullable = false, length = 64)
	private String password;
	@Basic
	@Column(name = "enabled", nullable = false)
	private Byte enabled;
	@Basic
	@Column(name = "email", nullable = false, length = 100)
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

	public Byte getEnabled() {
		return enabled;
	}

	public void setEnabled(Byte enabled) {
		this.enabled = enabled;
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Account account = (Account) o;

		if (username != null ? !username.equals(account.username) : account.username != null)
			return false;
		if (password != null ? !password.equals(account.password) : account.password != null)
			return false;
		if (enabled != null ? !enabled.equals(account.enabled) : account.enabled != null)
			return false;
		if (email != null ? !email.equals(account.email) : account.email != null)
			return false;
		if (phone != null ? !phone.equals(account.phone) : account.phone != null)
			return false;
		if (fullName != null ? !fullName.equals(account.fullName) : account.fullName != null)
			return false;
		if (address != null ? !address.equals(account.address) : account.address != null)
			return false;
		if (rankAccount != null ? !rankAccount.equals(account.rankAccount) : account.rankAccount != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = username != null ? username.hashCode() : 0;
		result = 31 * result + (password != null ? password.hashCode() : 0);
		result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (phone != null ? phone.hashCode() : 0);
		result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
		result = 31 * result + (address != null ? address.hashCode() : 0);
		result = 31 * result + (rankAccount != null ? rankAccount.hashCode() : 0);
		return result;
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
}
