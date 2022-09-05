package com.buimanhthanh.service;

import com.buimanhthanh.entity.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {
    Optional<Cart> getCartById(Integer id);

    Optional<List<Cart>> getAllCart();

    Boolean saveOrUpdateCart(Cart cart);

    void deleteCart(Integer id);

    void deleteCart(List<Integer> ids);
}
