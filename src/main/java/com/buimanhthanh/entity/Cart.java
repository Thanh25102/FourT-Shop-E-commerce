package com.buimanhthanh.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Cart {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	private Integer id;
	@Basic
	@Column(name = "customer_id", nullable = false)
	private Integer customerId;
	
	@ManyToOne
	@JoinColumn(name = "username", referencedColumnName = "username", nullable = false)
	private Account accountByUsername;
	
	@OneToMany(mappedBy = "cartByCartId")
	private Collection<CartDetail> cartDetailsById;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Cart cart = (Cart) o;

		if (id != null ? !id.equals(cart.id) : cart.id != null)
			return false;
		if (customerId != null ? !customerId.equals(cart.customerId) : cart.customerId != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
		return result;
	}

	public Account getAccountByUsername() {
		return accountByUsername;
	}

	public void setAccountByUsername(Account accountByUsername) {
		this.accountByUsername = accountByUsername;
	}

	public Collection<CartDetail> getCartDetailsById() {
		return cartDetailsById;
	}

	public void setCartDetailsById(Collection<CartDetail> cartDetailsById) {
		this.cartDetailsById = cartDetailsById;
	}
}
