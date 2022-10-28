package com.buimanhthanh.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Table(name ="cart")
@Data
public class Cart {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	@NotNull(message = "{null.err}")
	private Integer id;
	@Basic
	@Column(name = "ammount", nullable = false)
	@NotNull(message = "{null.err}")
	private Integer ammount;
	
	@ManyToOne
	@JoinColumn(name = "username", referencedColumnName = "username", nullable = false)
	private Account accountByUsername;
	
	@OneToMany(mappedBy = "cartByCartId")
	private Collection<CartDetail> cartDetailsById;
}
