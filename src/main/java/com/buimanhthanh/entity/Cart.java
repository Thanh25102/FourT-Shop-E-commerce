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
	@Column(name = "ammount", nullable = false)
	private Integer ammount;
	
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

	public Integer getAmmount() {
		return ammount;
	}

	public void setAmmount(Integer customerId) {
		this.ammount = customerId;
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
		if (ammount != null ? !ammount.equals(cart.ammount) : cart.ammount != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (ammount != null ? ammount.hashCode() : 0);
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
