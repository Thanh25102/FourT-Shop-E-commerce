package com.buimanhthanh.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.buimanhthanh.entity.Cart;
import com.buimanhthanh.service.CartService;

@Controller
@RequestMapping("/admin")
public class CartController {
    @Autowired
    private CartService cartService;
    @GetMapping("/cart")
    public String cart(ModelMap model) {
        model.addAttribute("model", Cart.class.getSimpleName());
        System.out.println(Cart.class.getSimpleName());
        model.addAttribute("listObject", cartService.getAllCart().get());
        return "adminTable";
    }
}
