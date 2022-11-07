package com.buimanhthanh.service;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.dto.CartDTO;

public interface CartService {
	Optional<CartDTO> getCartById(Integer id);

	Optional<List<CartDTO>> getAllCart();


	Optional<CartDTO> getCartByUsername(String username);
	
	Boolean saveOrUpdateCart(CartDTO cartDTO);

	void deleteCart(Integer id);

	void deleteCart(List<Integer> ids);
}
