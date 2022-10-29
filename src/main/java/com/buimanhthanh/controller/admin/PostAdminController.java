package com.buimanhthanh.controller.admin;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.buimanhthanh.entity.Account;
import com.buimanhthanh.entity.Cart;
import com.buimanhthanh.entity.Category;
import com.buimanhthanh.entity.Color;
import com.buimanhthanh.entity.Discount;
import com.buimanhthanh.entity.DiscountCode;
import com.buimanhthanh.entity.Order;
import com.buimanhthanh.entity.Product;
import com.buimanhthanh.entity.ProductDetail;
import com.buimanhthanh.entity.Role;
import com.buimanhthanh.entity.Size;
import com.buimanhthanh.service.AccessService;
import com.buimanhthanh.service.AccountService;
import com.buimanhthanh.service.CartService;
import com.buimanhthanh.service.CategoryService;
import com.buimanhthanh.service.ColorService;
import com.buimanhthanh.service.DiscountCodeService;
import com.buimanhthanh.service.DiscountService;
import com.buimanhthanh.service.OrderService;
import com.buimanhthanh.service.ProductDetailService;
import com.buimanhthanh.service.ProductService;
import com.buimanhthanh.service.RoleService;
import com.buimanhthanh.service.SizeService;

@Controller
@RequestMapping("/admin")
public class PostAdminController {}
