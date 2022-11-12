package com.buimanhthanh.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.buimanhthanh.dto.AccountDTO;
import com.buimanhthanh.dto.ResponeObject;
import com.buimanhthanh.service.CartService;

@RestController
@RequestMapping("/api/v1/cart")
public class APICart {
	@Autowired
	private CartService cartService;

	@PostMapping("/{productId}")
	public ResponseEntity<ResponeObject> addProductToCart(@PathVariable Integer productId, HttpSession session) {
		AccountDTO accountDTO = null;
		if (session.getAttribute("currentUser") != null) {
			accountDTO = (AccountDTO) session.getAttribute("currentUser");
			System.out.println(accountDTO.toString() + "-------" + productId);
			Boolean exist = cartService.addProductToCart(productId, accountDTO.getUsername());
			if (exist) {
				return ResponseEntity.status(HttpStatus.OK)
						.body(new ResponeObject("ok", "Add Cart successfully", true));
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(new ResponeObject("fail", "San pham khong con", false));
			}
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponeObject("fail", "You need login", false));
		}
	}

//	@PutMapping("/{id}")
//	public ResponseEntity<ResponeObject> updateCart(@RequestBody CartDTO cartDTO, @PathVariable Integer id) {
//		Optional<CartDTO> oplCartDTO = cartService.getCartById(id);
//		return oplCartDTO.isEmpty()
//				? ResponseEntity.status(HttpStatus.NOT_FOUND)
//						.body(new ResponeObject("fail", "Not found cart with id : " + id, false))
//				: ResponseEntity.status(HttpStatus.OK).body(
//						new ResponeObject("ok", "Update Account successfully", cartService.saveOrUpdateCart(cartDTO)));
//	}
//
	@DeleteMapping("/{cartDetailId}")
	public ResponseEntity<ResponeObject> removeCart(@PathVariable Integer cartDetailId, HttpSession session) {
		if (session.getAttribute("currentUser") != null) {
			cartService.removeProductFromCart(cartDetailId);
			return ResponseEntity.status(HttpStatus.OK).body(new ResponeObject("ok", "delete successfully", true));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponeObject("failer", "You need login", false));
		}
	}

	@GetMapping("/quantity")
	public ResponseEntity<ResponeObject> quantityOfProduct(HttpSession session) {
		if (session.getAttribute("currentUser") != null) {
			AccountDTO accountDTO = (AccountDTO) session.getAttribute("currentUser");
			return ResponseEntity.status(HttpStatus.OK).body(new ResponeObject("ok", "Quantity product of user : ",
					cartService.getQuantityOfCart(accountDTO.getUsername())));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponeObject("fail", "You need login", false));
		}
	}

	@PostMapping("/quantity/{productDetailId}")
	public ResponseEntity<ResponeObject> updateQuantity(@PathVariable Integer productDetailId,
			@RequestParam String type) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponeObject("ok", "update quantity cart detail successfully",
						cartService.updateQuantityCartDetail(type, productDetailId).get()));
	}

}
