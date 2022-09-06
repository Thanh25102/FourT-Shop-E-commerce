package com.buimanhthanh.dao;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.entity.Cart;

public interface CartDao {
    Optional<Cart> getCartById(Integer id);

    Optional<List<Cart>> getAllCart();

    Boolean saveOrUpdateCart(Cart cart);

    void deleteCart(Integer id);

    void deleteCart(List<Integer> ids);
}
