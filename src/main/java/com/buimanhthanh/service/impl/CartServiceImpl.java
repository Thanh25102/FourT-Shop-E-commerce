package com.buimanhthanh.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buimanhthanh.dao.CartDao;
import com.buimanhthanh.dao.ProductDao;
import com.buimanhthanh.dao.ProductDetailDao;
import com.buimanhthanh.dto.CartDTO;
import com.buimanhthanh.dto.CartDetailDTO;
import com.buimanhthanh.dto.ProductDTO;
import com.buimanhthanh.dto.ProductDetailDTO;
import com.buimanhthanh.entity.Account;
import com.buimanhthanh.entity.Cart;
import com.buimanhthanh.entity.CartDetail;
import com.buimanhthanh.entity.ProductDetail;
import com.buimanhthanh.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartDao cartDao;
	@Autowired
	private ProductDetailDao productDetailDao;
	@Autowired
	private ProductDao productDao;

	@Override
	@Transactional
	public Optional<CartDTO> getCartById(Integer id) {
		return cartDao.getCartById(id);
	}

	@Override
	@Transactional
	public Optional<CartDTO> getCartByUsername(String username) {
		return cartDao.getCartByUsername(username);
	}

	@Override
	@Transactional
	public Optional<List<CartDTO>> getAllCart() {
		return cartDao.getAllCart();
	}

	@Override
	@Transactional
	public Boolean saveOrUpdateCart(CartDTO cartDTO) {
		Cart cart = new Cart(cartDTO.getId(), cartDTO.getAmmount(), null, null);
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

	@Override
	@Transactional
	public Optional<List<CartDetailDTO>> getCartDetailByCart(Integer cartId) {
		return cartDao.getCartDetailByCart(cartId);
	}

	@Override
	@Transactional
	public Boolean saveOrUpdateCartDetail(CartDetailDTO cartDetailDTO) {
		ProductDetail productDetail = new ProductDetail();
		productDetail.setId(cartDetailDTO.getProductId());
		Cart cart = new Cart();
		cart.setId(cartDetailDTO.getCartId());
		CartDetail cartDetail = new CartDetail(cartDetailDTO.getId(), cartDetailDTO.getPrice(),
				cartDetailDTO.getQuantity(), productDetail, cart);
		return cartDao.saveOrUpdateCartDetail(cartDetail);
	}

	@Override
	@Transactional
	public Boolean addProductToCart(Integer productId, String username) {
		Optional<CartDTO> oplCartDTO = getCartByUsername(username);

		List<ProductDetailDTO> productDetailDTOs = productDetailDao.getProductDetailByProductId(productId).get();
		if (productDetailDTOs.size() == 0) {
			return false;
		}
		ProductDetailDTO productDetailDTO = productDetailDTOs.get(0);

		ProductDTO productDTO = productDao.getProductById(productId).get();

		Account account = new Account();
		account.setUsername(username);

		oplCartDTO.ifPresentOrElse(c -> {
			c.setAmmount(c.getAmmount() + 1);
			if (isExistProductDetailInCart(productDetailDTO.getId(), c.getId())) {
				CartDetailDTO cartDetailDTO = getCartDetailByProductDetailId(productDetailDTO.getId(), c.getId()).get();
				cartDetailDTO.setQuantity(cartDetailDTO.getQuantity() + 1);
				cartDetailDTO.setPrice(cartDetailDTO.getQuantity() * productDTO.getPrice());

				this.saveOrUpdateCartDetail(cartDetailDTO);
			} else {
				CartDetailDTO cartDetailDTO = new CartDetailDTO(null, productDetailDTO.getId(), c.getId(),
						productDTO.getPrice() * 1, 1);
				cartDetailDTO.setPrice(cartDetailDTO.getQuantity() * productDTO.getPrice());

				this.saveOrUpdateCartDetail(cartDetailDTO);
			}
			this.saveOrUpdateCart(c);
		}, () -> {
			CartDTO cartDTO = new CartDTO(null, 1, username);
			this.saveOrUpdateCart(cartDTO);
			Optional<CartDTO> oplCartDTO2 = getCartByUsername(username);
			oplCartDTO2.ifPresent(c -> {
				CartDetailDTO cartDetailDTO = new CartDetailDTO(null, productDetailDTO.getId(), c.getId(),
						productDTO.getPrice() * 1, 1);

				this.saveOrUpdateCartDetail(cartDetailDTO);
			});
		});
		return true;
	}

	@Override
	@Transactional
	public Integer removeProductFromCart(Integer cartDetailId) {
		return cartDao.removeProductFromCart(cartDetailId);
	}

	@Override
	@Transactional
	public Integer getQuantityOfCart(String username) {
		return cartDao.getQuantityOfCart(username);
	}

	@Override
	@Transactional
	public Integer getQuantityOfCartDetail(Integer cartDetailId) {
		return cartDao.getQuantityOfCartDetail(cartDetailId);
	}

	@Override
	@Transactional
	public Boolean isExistProductDetailInCart(Integer productDetailId, Integer cartId) {
		return cartDao.isExistProductDetailInCart(productDetailId, cartId);
	}

	@Override
	@Transactional
	public Boolean updateQuantityProductDetailInCartDetail(Integer quantity, Integer cartDetailId) {
		return cartDao.updateQuantityProductDetailInCartDetail(quantity, cartDetailId);
	}

	@Override
	@Transactional
	public Optional<CartDetailDTO> getCartDetailByProductDetailId(Integer productDetailId, Integer cartId) {
		return cartDao.getCartDetailByProductDetailId(productDetailId, cartId);
	}

}
