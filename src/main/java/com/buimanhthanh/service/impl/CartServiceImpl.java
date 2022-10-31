package com.buimanhthanh.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buimanhthanh.dao.CartDao;
import com.buimanhthanh.dto.CartDTO;
import com.buimanhthanh.entity.Account;
import com.buimanhthanh.entity.Cart;
import com.buimanhthanh.service.CartService;
@Service
public class CartServiceImpl implements CartService {
    @Autowired private CartDao cartDao;

    @Override
    @Transactional
    public Optional<CartDTO> getCartById(Integer id) {
        return cartDao.getCartById(id);
    }

    @Override
    @Transactional
    public Optional<List<CartDTO>> getAllCart() {
        return cartDao.getAllCart();
    }

    @Override
    @Transactional
    public Boolean saveOrUpdateCart(CartDTO cartDTO) {
    	Cart cart = new Cart(cartDTO.getId(),cartDTO.getAmmount(),null,null);
    	Account account = new Account();
    	account.setUsername(cartDTO.getUsername());
    	cart.setAccountByUsername(account);
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
