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
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@PostMapping("/account")
	public String account(ModelMap model, @ModelAttribute("Account") @Valid Account account, BindingResult result) {
		userDetailService.getAccountByUsername(account.getUsername()).ifPresent(a -> result.addError(new ObjectError(
				"username",
				messageSource.getMessage("account.username.err.exist", null, "username has already exists :D", null))));
		userDetailService.getAccountByEmail(account.getEmail()).ifPresent(a -> result.addError(new ObjectError("email",
				messageSource.getMessage("account.email.err.exist", null, "email has already exists :D", null))));
		String passwordEncode = passwordEncoder.encode(account.getPassword());
		if (result.hasErrors() || !account.getPassword().equals(account.getPasswordConfirm())) {
			result.addError(new ObjectError("passwordConfirm", "password does not match"));
			return "redirect:/admin/account";
		} else {
			account.setPassword(passwordEncode);
			account.setPasswordConfirm(passwordEncode);
			userDetailService.saveOrUpdateAccount(account);
			return "redirect:/admin/account";
		}
	}

	@PostMapping("/account/edit/{username}")
	public String updateAccount(ModelMap model, @ModelAttribute("Account") @Valid Account account, BindingResult result,
			@PathVariable String username) {
		if (result.hasErrors())
			return "redirect:/admin/account?action=update&&username=" + username;
		else {
			userDetailService.saveOrUpdateAccount(account);
			return "redirect:/admin/account";
		}
	}

	@GetMapping("/account/delete/{username}")
	public String disableAccount(ModelMap model, @PathVariable(required = true) String username) {
		Account account = userDetailService.getAccountByUsername(username).get();
		account.setEnabled4(false);
		account.setPasswordConfirm(account.getPassword());
		userDetailService.saveOrUpdateAccount(account);
		return "redirect:/admin/account";
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

	@PostMapping("/product/detail/{id}")
	public String productDetail(ModelMap model, @ModelAttribute("productDetailForm") @Valid ProductDetail productDetail,
			BindingResult result, @PathVariable(required = true) Integer id) {
		if (result.hasErrors()) {
			return "redirect:/admin/product/detail/" + id + "?action=update&&detailId=" + productDetail.getId();
		} else {
			productDetailService.saveOrUpdateProductDetail(productDetail);
			return "redirect:/admin/product/detail/" + id;
		}
	}

	@PostMapping("/product/detail/delete/{id}")
	public void productDetail(@PathVariable(required = true) Integer id) {
		productDetailService.deleteProductDetail(id);
	}

	@PostMapping("/category")
	public String category(ModelMap model, @ModelAttribute("Category") @Valid Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/admin/category?action=add";
		} else {
			categoryService.saveOrUpdateCategory(category);
			return "redirect:/admin/category";
		}
	}

	@PostMapping("/category/edit/{id}")
	public String updateCategory(ModelMap model, @ModelAttribute("Category") @Valid Category category,
			BindingResult result, @PathVariable(required = true) Integer id) {
		if (result.hasErrors()) {
			return "redirect:/admin/category?action=update&&id=" + id;
		} else {
			categoryService.saveOrUpdateCategory(category);
			return "redirect:/admin/category";
		}
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
			return "redirect:/admin/color?action=add";
		else {
			colorService.saveOrUpdateColor(color);
			return "redirect:/admin/color";
		}
	}

	@PostMapping("/color/edit/{id}")
	public String updateColor(ModelMap model, @ModelAttribute("color") @Valid Color color, BindingResult result,
			@PathVariable(required = true) Integer id) {
		if (result.hasErrors())
			return "redirect:/admin/color?action=update&&id=" + id;
		else {
			colorService.saveOrUpdateColor(color);
			return "redirect:/admin/color";
		}
	}

	@PostMapping("/size")
	public String size(ModelMap model, @ModelAttribute("size") @Valid Size size, BindingResult result) {
		if (result.hasErrors())
			return "redirect:/admin/size?action=add";
		else {
			sizeService.saveOrUpdateSize(size);
			return "redirect:/admin/size";
		}
	}

	@PostMapping("/size/edit/{id}")
	public String updateSize(ModelMap model, @ModelAttribute("size") @Valid Size size, BindingResult result,
			@PathVariable(required = true) Integer id) {
		if (result.hasErrors())
			return "redirect:/admin/size?action=update&&id=" + id;
		else {
			sizeService.saveOrUpdateSize(size);
			return "redirect:/admin/size";
		}
	}

	@PostMapping("/discount")
	public String discount(ModelMap model, @ModelAttribute("discount") @Valid Discount discount, BindingResult result) {
		if (result.hasErrors())
			return "redirect:/admin/discount?action=add";
		else {
			discountService.saveOrUpdateDiscount(discount);
			return "redirect:/admin/discount";
		}
	}

	@PostMapping("/discount/edit/{id}")
	public String updateDiscount(ModelMap model, @ModelAttribute("Discount") @Valid Discount discount,
			BindingResult result, @PathVariable Integer id) {
		if (result.hasErrors())
			return "redirect:/admin/discount?action=update&&id="+id;
		else {
			discountService.saveOrUpdateDiscount(discount);
			return "redirect:/admin/discount";
		}
	}

	@PostMapping("/discount_code")
	public String discountCode(ModelMap model, @ModelAttribute("DiscountCode") @Valid DiscountCode discountCode,
			BindingResult result) {
		if (result.hasErrors())
			return "redirect:/admin/discount_code?action=add";
		else {
			discountCodeService.saveOrUpdateDiscountCode(discountCode);
			return "redirect:/admin/discount_code";
		}
	}

	@PostMapping("/discount_code/edit/{id}")
	public String updateDiscountCode(ModelMap model, @ModelAttribute("DiscountCode") @Valid DiscountCode discountCode,
			BindingResult result, @PathVariable Integer id) {
		if (result.hasErrors())
			return "redirect:/admin/discount_code?action=update&&id=" + id;
		else {
			discountCodeService.saveOrUpdateDiscountCode(discountCode);
			return "redirect:/admin/discount_code";
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
}
