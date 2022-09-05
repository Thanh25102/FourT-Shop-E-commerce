package com.buimanhthanh.service.impl;

import com.buimanhthanh.dao.CartDao;
import com.buimanhthanh.entity.Cart;
import com.buimanhthanh.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;

    @Override
    @Transactional
    public Optional<Cart> getCartById(Integer id) {
        return cartDao.getCartById(id);
    }

    @Override
    @Transactional
    public Optional<List<Cart>> getAllCart() {
        return cartDao.getAllCart();
    }

    @Override
    @Transactional
    public Boolean saveOrUpdateCart(Cart cart) {
        return cartDao.saveOrUpdateCart(cart);
    }

    @Override
    @Transactional
    public void deleteCart(Integer id) {
        cartDao.deleteCart(id);
    }

    @Override
    @Transactional
    public void deleteCart(List<Integer> ids) {
        cartDao.deleteCart(ids);

    }
}
