package com.buimanhthanh.controller.home;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.buimanhthanh.dto.AccountDTO;

@Controller
@RequestMapping("/checkout")
public class HomeCheckOutController {
	
	@GetMapping(value = {"","/"})
	public String checkout() {
		return "checkout";
	}
	
	@GetMapping("/proceed_check_out")
	public String proceedCheckOut(@PathVariable String username,ModelMap modelMap,HttpSession session) {
		AccountDTO accountDTO = null;
		if (session.getAttribute("currentUser") != null) {
			accountDTO = (AccountDTO) session.getAttribute("currentUser");
		} else {
			accountDTO = new AccountDTO();
		}
		return "checkout";
	
	}
}
