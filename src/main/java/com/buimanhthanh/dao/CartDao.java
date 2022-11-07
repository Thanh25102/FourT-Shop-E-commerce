package com.buimanhthanh.dao;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.dto.CartDTO;
import com.buimanhthanh.entity.Cart;

public interface CartDao {
    Optional<CartDTO> getCartById(Integer id);

    Optional<List<CartDTO>> getAllCart();
    
    Optional<CartDTO> getCartByUsername(String username);
    
    Boolean saveOrUpdateCart(Cart cart);

    void deleteCart(Integer id);

    void deleteCart(List<Integer> ids);
}
