package com.buimanhthanh.controller.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.buimanhthanh.service.CartService;

@Controller
@RequestMapping("")
public class HomeCartController {
	@Autowired private CartService cartService;
	
    @GetMapping("/cart")
    public String cart() {
        return "cart";
    }
}
