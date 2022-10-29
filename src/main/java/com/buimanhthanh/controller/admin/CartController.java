package com.buimanhthanh.controller.admin;

import com.buimanhthanh.entity.Cart;
import com.buimanhthanh.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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

    @PostMapping("/cart")
    public String cart(ModelMap model, @ModelAttribute("cart") @Valid Cart cart, BindingResult result) {
        if (result.hasErrors())
            return "adminTable";
        else {
            cartService.saveOrUpdateCart(cart);
            return "redirect:/cart";
        }
    }
}
