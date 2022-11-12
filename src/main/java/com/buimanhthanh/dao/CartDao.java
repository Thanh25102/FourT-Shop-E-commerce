package com.buimanhthanh.dao;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.dto.CartDTO;
import com.buimanhthanh.dto.CartDetailDTO;
import com.buimanhthanh.entity.Cart;
import com.buimanhthanh.entity.CartDetail;

public interface CartDao {
	Optional<CartDTO> getCartById(Integer id);

	Optional<List<CartDTO>> getAllCart();

	Optional<CartDTO> getCartByUsername(String username);

	Boolean saveOrUpdateCart(Cart cart);

	void deleteCart(Integer id);

	void deleteCart(List<Integer> ids);

	Optional<List<CartDetailDTO>> getCartDetailByCart(Integer cartId);

	Boolean saveOrUpdateCartDetail(CartDetail cartDetail);

	Integer removeProductFromCart(Integer cartDetailId);

	Integer getQuantityOfCart(String username);

	Integer getQuantityOfCartDetail(Integer cartDetailId);

	Boolean isExistProductDetailInCart(Integer productDetailId, Integer cartId);

	Boolean updateQuantityProductDetailInCartDetail(Integer quantity, Integer cartDetailId);

	Optional<CartDetailDTO> getCartDetailByProductDetailId(Integer productDetailId, Integer cartId);
	
	Optional<CartDetailDTO> getCartDetailById(Integer id);

}
