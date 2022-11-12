package com.buimanhthanh.service;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.dto.CartDTO;
import com.buimanhthanh.dto.CartDetailDTO;

public interface CartService {
	Optional<CartDTO> getCartById(Integer id);

	Optional<List<CartDTO>> getAllCart();

	Optional<CartDTO> getCartByUsername(String username);

	Boolean saveOrUpdateCart(CartDTO cartDTO);

	Boolean saveOrUpdateCartDetail(CartDetailDTO cartDetailDTO);

	void deleteCart(Integer id);

	void deleteCart(List<Integer> ids);

	Optional<List<CartDetailDTO>> getCartDetailByCart(Integer cartId);

	Boolean addProductToCart(Integer productId, String username);

	Integer removeProductFromCart(Integer productId);

	Integer getQuantityOfCart(String username);

	Integer getQuantityOfCartDetail(Integer cartDetailId);

	Boolean isExistProductDetailInCart(Integer productDetailId, Integer cartId);

	Boolean updateQuantityProductDetailInCartDetail(Integer quantity, Integer cartDetailId);

	Optional<CartDetailDTO> getCartDetailByProductDetailId(Integer productDetailId, Integer cartId);
	
	Optional<CartDetailDTO> getCartDetailById(Integer id);
	
	Optional<CartDetailDTO> updateQuantityCartDetail(String type,Integer cartDetailId);
}
