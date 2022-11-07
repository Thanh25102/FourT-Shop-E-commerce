package com.buimanhthanh.controller.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buimanhthanh.dto.CartDTO;
import com.buimanhthanh.dto.ResponeObject;
import com.buimanhthanh.service.CartService;

@RestController
@RequestMapping("/api/v1/cart")
public class CartAPI {
	@Autowired
	private CartService cartService;

	@GetMapping("/{username}")
	public ResponseEntity<ResponeObject> getCartByUsername(@PathVariable String username) {
		Optional<CartDTO> cartDTO = cartService.getCartByUsername(username);
		return cartDTO.isPresent()
				? ResponseEntity.status(HttpStatus.OK)
						.body(new ResponeObject("ok", "Query cart by username success", cartDTO.get()))
				: ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(new ResponeObject("fail", "Cannot find cart by username: " + username, cartDTO.get()));
	};

	@PostMapping("")
	public ResponseEntity<ResponeObject> addCart(@RequestBody CartDTO cartDTO) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponeObject("ok", "Insert cart successfully", cartService.saveOrUpdateCart(cartDTO)));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponeObject> updateCart(@RequestBody CartDTO cartDTO, @PathVariable Integer id) {
		Optional<CartDTO> oplCartDTO = cartService.getCartById(id);
		return oplCartDTO.isEmpty()
				? ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(new ResponeObject("fail", "Not found cart with id : " + id, false))
				: ResponseEntity.status(HttpStatus.OK).body(
						new ResponeObject("ok", "Update Account successfully", cartService.saveOrUpdateCart(cartDTO)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponeObject> deleteCart(@PathVariable Integer id) {
		cartService.deleteCart(id);
		return ResponseEntity.status(HttpStatus.OK).body(new ResponeObject("ok", "delete successfully", true));
	}
}
