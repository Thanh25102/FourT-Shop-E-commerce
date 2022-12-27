package com.buimanhthanh.controller.home;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.buimanhthanh.dto.AccountDTO;
import com.buimanhthanh.dto.CartDetailDTO;
import com.buimanhthanh.service.CartService;

@Controller
@RequestMapping("")
public class HomeCartController {
	@Autowired
	private CartService cartService;

	@GetMapping("/cart")
	public String cart(ModelMap modelMap, HttpSession session) {
		AccountDTO accountDTO = null;
		if (session.getAttribute("currentUser") != null) {
			accountDTO = (AccountDTO) session.getAttribute("currentUser");
		} else {
			accountDTO = new AccountDTO();
		}
		cartService.getCartByUsername(accountDTO.getUsername()).ifPresentOrElse(c -> {
			List<CartDetailDTO> cartDetailDTO = cartService.getCartDetailByCart(c.getId()).get();
			cartDetailDTO.forEach(c2->{System.out.println(c2);});
			modelMap.addAttribute("cartDetails", cartDetailDTO);
		}, () -> modelMap.addAttribute("cartDetails", new ArrayList<CartDetailDTO>()));
		return "cart";
	}
}
