package com.buimanhthanh.controller.admin;

import com.buimanhthanh.entity.*;
import com.buimanhthanh.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Access;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class PostAdminController {
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private AccountService userDetailService;
    @Autowired
    private DiscountService discountService;
    @Autowired
    private DiscountCodeService discountCodeService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private AccessService accessService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SizeService sizeService;
    @Autowired
    private ColorService colorService;

    @PostMapping("/account")
    public String account(ModelMap model, @ModelAttribute("Account") @Valid Account account, BindingResult result) {
        Optional<Account> optionalAccount = userDetailService.getAccountByUsername(account.getUsername());
        optionalAccount
                .ifPresent(a -> result.addError(new ObjectError("username", messageSource.getMessage("account.username.err.exist",null,"username has already exists :D",null))));
        userDetailService.getAccountByEmail(account.getEmail())
                .ifPresent(a -> result.addError(new ObjectError("email", messageSource.getMessage("account.email.err.exist",null,"email has already exists :D",null))));
        if(result.hasErrors())
            return "adminTable";
        else{
            userDetailService.saveOrUpdateAccount(account);
            return "redirect:/account";
        }
    }
    @PostMapping("/product")
    public String product(ModelMap model, @ModelAttribute("Product") @Valid Product product, BindingResult result){
        if(result.hasErrors())
            return "adminTable";
        else {
            productService.saveOrUpdateProduct(product);
            return "redirect:/product";
        }
    }
    @PostMapping("/role")
    public String role(ModelMap model, @ModelAttribute("role") @Valid Role role, BindingResult result){
        if(result.hasErrors())
            return "adminTable";
        else{
            roleService.saveOrUpdateRole(role);
            return "redirect:/role";
        }
    }
    @PostMapping("/color")
    public String color(ModelMap model, @ModelAttribute("color") @Valid Color color, BindingResult result){
        if(result.hasErrors())
            return "adminTable";
        else{
            colorService.saveOrUpdateColor(color);
            return "redirect:/color";
        }
    }
    @PostMapping("/size")
    public String size(ModelMap model, @ModelAttribute("size") @Valid Size size,BindingResult result){
        if(result.hasErrors())
            return "adminTable";
        else{
            sizeService.saveOrUpdateSize(size);
            return "redirect:/size";
        }
    }
    @PostMapping("/discount")
    public String discount(ModelMap model,@ModelAttribute("discount") @Valid Discount discount,BindingResult result){
        if(result.hasErrors())
            return "adminTable";
        else{
            discountService.saveOrUpdateDiscount(discount);
            return "redirect:/discount";
        }
    }
    @PostMapping("/discount_code")
    public String discountCode(ModelMap model,@ModelAttribute("discountCode") @Valid DiscountCode discountCode,BindingResult result){
        if(result.hasErrors())
            return "adminTable";
        else{
            discountCodeService.saveOrUpdateDiscountCode(discountCode);
            return "redirect:/discount_code";
        }
    }
    @PostMapping("/order")
    public String order(ModelMap model,@ModelAttribute("discountCode") @Valid Order order,BindingResult result){
        if(result.hasErrors())
            return "adminTable";
        else{
            orderService.saveOrUpdateOrder(order);
            return "redirect:/order";
        }
    }
    @PostMapping("/cart")
    public String cart(ModelMap model,@ModelAttribute("cart") @Valid Cart cart,BindingResult result){
        if(result.hasErrors())
            return "adminTable";
        else{
            cartService.saveOrUpdateCart(cart);
            return "redirect:/cart";
        }
    }
    @PostMapping("/category")
    public String category(ModelMap model, @ModelAttribute("category") @Valid Category category,BindingResult result){
        if(result.hasErrors())
            return "adminTable";
        else {
            categoryService.saveOrUpdateCategory(category);
            return "redirect:/category";
        }
    }
}
