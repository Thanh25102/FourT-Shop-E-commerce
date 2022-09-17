package com.buimanhthanh.controller.admin;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	@Autowired
	private ProductDetailService productDetailService;

	@PostMapping("/account")
	public String account(ModelMap model, @ModelAttribute("Account") @Valid Account account, BindingResult result) {
		Optional<Account> optionalAccount = userDetailService.getAccountByUsername(account.getUsername());
		optionalAccount.ifPresent(a -> result.addError(new ObjectError("username",
				messageSource.getMessage("account.username.err.exist", null, "username has already exists :D", null))));
		userDetailService.getAccountByEmail(account.getEmail()).ifPresent(a -> result.addError(new ObjectError("email",
				messageSource.getMessage("account.email.err.exist", null, "email has already exists :D", null))));
		if (result.hasErrors())
			return "adminTable";
		else {
			userDetailService.saveOrUpdateAccount(account);
			return "redirect:/account";
		}
	}

	@PostMapping("/product/edit/{id}")
	public String product(ModelMap model, @PathVariable(required = true) Integer id,
			@ModelAttribute("Product") @Valid Product product, BindingResult result) {
		if (result.hasErrors())
			return "redirect:/admin/product?action=update&&id=" + id;
		else {
			productService.saveOrUpdateProduct(product);
			return "redirect:/admin/product";
		}
	}

	@PostMapping("/product/delete/{id}")
	public String deleteProduct(ModelMap model, @PathVariable(required = true) Integer id) {
		productService.deleteProduct(id);
		return "redirect:/admin/product";
	}

	@PostMapping("/product-detail/{id}")
	public String productDetail(ModelMap model, @ModelAttribute("ProductDetail") @Valid ProductDetail productDetail,
			BindingResult result, @PathVariable(required = true) Integer id) {
		if (result.hasErrors()) {
			System.out.println("Looix ne`");
			return "redirect:/admin/product-detail/" + id + "?action=update&&detailId=" + productDetail.getId();
		}
		else {
			productDetailService.saveOrUpdateProductDetail(productDetail);
			return "redirect:/admin/product-detail/"+id;
		}
	}

	@PostMapping("/product-detail/delete/{id}")
	public void productDetail(@PathVariable(required = true)Integer id) {
		productDetailService.deleteProductDetail(id);
	}
	
	@PostMapping("/role")
	public String role(ModelMap model, @ModelAttribute("role") @Valid Role role, BindingResult result) {
		if (result.hasErrors())
			return "adminTable";
		else {
			roleService.saveOrUpdateRole(role);
			return "redirect:/role";
		}
	}

	@PostMapping("/color")
	public String color(ModelMap model, @ModelAttribute("color") @Valid Color color, BindingResult result) {
		if (result.hasErrors())
			return "adminTable";
		else {
			colorService.saveOrUpdateColor(color);
			return "redirect:/color";
		}
	}

	@PostMapping("/size")
	public String size(ModelMap model, @ModelAttribute("size") @Valid Size size, BindingResult result) {
		if (result.hasErrors())
			return "adminTable";
		else {
			sizeService.saveOrUpdateSize(size);
			return "redirect:/size";
		}
	}

	@PostMapping("/discount")
	public String discount(ModelMap model, @ModelAttribute("discount") @Valid Discount discount, BindingResult result) {
		if (result.hasErrors())
			return "adminTable";
		else {
			discountService.saveOrUpdateDiscount(discount);
			return "redirect:/discount";
		}
	}

	@PostMapping("/discount_code")
	public String discountCode(ModelMap model, @ModelAttribute("discountCode") @Valid DiscountCode discountCode,
			BindingResult result) {
		if (result.hasErrors())
			return "adminTable";
		else {
			discountCodeService.saveOrUpdateDiscountCode(discountCode);
			return "redirect:/discount_code";
		}
	}

	@PostMapping("/order")
	public String order(ModelMap model, @ModelAttribute("discountCode") @Valid Order order, BindingResult result) {
		if (result.hasErrors())
			return "adminTable";
		else {
			orderService.saveOrUpdateOrder(order);
			return "redirect:/order";
		}
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

	@PostMapping("/category")
	public String category(ModelMap model, @ModelAttribute("category") @Valid Category category, BindingResult result) {
		if (result.hasErrors())
			return "adminTable";
		else {
			categoryService.saveOrUpdateCategory(category);
			return "redirect:/category";
		}
	}
}
