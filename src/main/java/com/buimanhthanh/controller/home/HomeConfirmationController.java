package com.buimanhthanh.controller.home;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.buimanhthanh.dto.AccountDTO;
import com.buimanhthanh.dto.OrderDTO;
import com.buimanhthanh.service.OrderService;

@Controller
@RequestMapping("")
public class HomeConfirmationController {
	@Autowired private OrderService orderService;
	
    @GetMapping("/confirmation")
    public String confirmation(ModelMap modelMap,HttpSession session) {
    	AccountDTO accountDTO = null;
		if (session.getAttribute("currentUser") != null) {
			accountDTO = (AccountDTO) session.getAttribute("currentUser");
			modelMap.addAttribute("orders",orderService.getOrderByUsername(accountDTO.getUsername()).get());
		} else {
			accountDTO = new AccountDTO();
			modelMap.addAttribute("orders",new ArrayList<OrderDTO>());
		} 
        return "confirmation";
    }
}
