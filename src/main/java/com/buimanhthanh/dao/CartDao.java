package com.buimanhthanh.dao;

import com.buimanhthanh.entity.Cart;
import com.buimanhthanh.entity.Order;

import java.util.List;
import java.util.Optional;

public interface CartDao {
    Optional<Cart> getCartById(Integer id);

    Optional<List<Cart>> getAllCart();

    Boolean saveOrUpdateCart(Cart cart);

    void deleteCart(Integer id);

    void deleteCart(List<Integer> ids);
}
