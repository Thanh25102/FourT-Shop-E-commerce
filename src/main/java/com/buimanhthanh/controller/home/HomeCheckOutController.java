package com.buimanhthanh.controller.home;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.buimanhthanh.dto.AccountDTO;
import com.buimanhthanh.dto.CartDTO;
import com.buimanhthanh.dto.CartDetailDTO;
import com.buimanhthanh.dto.DiscountCodeDTO;
import com.buimanhthanh.dto.OrderDTO;
import com.buimanhthanh.dto.OrderDetailDTO;
import com.buimanhthanh.entity.DiscountCode;
import com.buimanhthanh.service.CartService;
import com.buimanhthanh.service.DiscountCodeService;
import com.buimanhthanh.service.OrderService;

@Controller
@RequestMapping("/checkout")
public class HomeCheckOutController {

	@Autowired
	private CartService cartService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private DiscountCodeService discountCodeService;

	@GetMapping(value = { "/", "" })
	public String proceedCheckOut(ModelMap modelMap, HttpSession session) {
		AccountDTO accountDTO = null;
		if (session.getAttribute("currentUser") != null) {
			accountDTO = (AccountDTO) session.getAttribute("currentUser");
		} else {
			accountDTO = new AccountDTO();
		}
		CartDTO cartDTO = cartService.getCartByUsername(accountDTO.getUsername()).get();
		List<CartDetailDTO> cartDetailDTOs = cartService.getCartDetailByCart(cartDTO.getId()).get();
		modelMap.addAttribute("cart", cartDTO);
		modelMap.addAttribute("cartDetails", cartDetailDTOs);
		modelMap.addAttribute("order", new OrderDTO());
		return "checkout";
	}

	@PostMapping("/process")
	public String checkOut(@ModelAttribute("order") OrderDTO order, HttpSession session) {
		AccountDTO accountDTO = (AccountDTO) session.getAttribute("currentUser");
		orderService.checkOut(order, accountDTO);
		return "redirect:/";
	}

}
