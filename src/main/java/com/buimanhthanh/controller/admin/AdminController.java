package com.buimanhthanh.controller.admin;

import com.buimanhthanh.entity.*;
import com.buimanhthanh.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("/admin")
public class AdminController {

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

	@GetMapping("/")
	public String index() {

		return "adminIndex";
	}

	@GetMapping("/table")
	public String table() {
		return "adminTable";
	}

	@GetMapping("/account")
	public String account(ModelMap model) {
		userDetailService.getAllAccount().get().forEach(System.out::println);
		model.addAttribute("model", Account.class.getSimpleName());
		System.out.println(Account.class.getSimpleName());
		userDetailService.getAllAccount().get().forEach(a -> System.out.println(a));
		model.addAttribute("listObject", userDetailService.getAllAccount().get());
		return "adminTable";
	}

	@GetMapping("/discount_code")
	public String discountCode(ModelMap model) {
		model.addAttribute("model", DiscountCode.class.getSimpleName());
		System.out.println(DiscountCode.class.getSimpleName());
		model.addAttribute("listObject", discountCodeService.getAllDiscountCode().get());
		return "adminTable";
	}

	@GetMapping("/discount")
	public String discount(ModelMap model) {
		model.addAttribute("model", Discount.class.getSimpleName());
		System.out.println(Discount.class.getSimpleName());
		model.addAttribute("listObject", discountService.getAllDiscount().get());
		return "adminTable";
	}

	@GetMapping("/role")
	public String role(ModelMap model) {
		model.addAttribute("model", Role.class.getSimpleName());
		System.out.println(Role.class.getSimpleName());
		model.addAttribute("listObject", roleService.getAllRole().get());
		return "adminTable";
	}

	@GetMapping("/access")
	public String access(ModelMap model) {
		model.addAttribute("model", Access.class.getSimpleName());
		System.out.println(Access.class.getSimpleName());
		model.addAttribute("listObject", accessService.getAllAccess().get());
		return "adminTable";
	}

	@GetMapping("/order")
	public String order(ModelMap model) {
		model.addAttribute("model", Order.class.getSimpleName());
		System.out.println(Order.class.getSimpleName());
		model.addAttribute("listObject", orderService.getAllOrder().get());
		return "adminTable";
	}

	@GetMapping("/cart")
	public String cart(ModelMap model) {

		model.addAttribute("model", Cart.class.getSimpleName());
		System.out.println(Cart.class.getSimpleName());
		model.addAttribute("listObject", cartService.getAllCart().get());
		return "adminTable";
	}

	@GetMapping("/product")
	public String product(ModelMap model, @RequestParam(required = false, defaultValue = "-1") Integer id,
			@RequestParam(required = false, defaultValue = "null") String action) {
		model.addAttribute("model", Product.class.getSimpleName());
		if (action.equals("update")) {
			productService.getProductById(id).ifPresentOrElse(p -> model.addAttribute("Product", p),
					() -> model.addAttribute("Product", new Product()));
			categoryService.getAllCategory().ifPresentOrElse(c -> model.addAttribute("Categories", c),
					() -> model.addAttribute("Categories", new ArrayList<Category>()));
		} else if (action.equals("add")) {
			model.addAttribute("Product", new Product());
			categoryService.getAllCategory().ifPresentOrElse(c -> model.addAttribute("Categories", c),
					() -> model.addAttribute("Categories", new ArrayList<Category>()));
		}
		model.addAttribute("listObject", productService.getAllProduct().get());
		return "adminTable";
	}

	@GetMapping("/product-detail/{id}")
	public String productDetail(ModelMap model, @PathVariable Integer id,
			@RequestParam(required = false, defaultValue = "-1") Integer detailId,
			@RequestParam(required = false, defaultValue = "null") String action) {
		model.addAttribute("model", ProductDetail.class.getSimpleName());
		model.addAttribute("pathVariable",id);
		productService.getProductById(id).ifPresentOrElse(
				p -> model.addAttribute("ProductDetails", p.getProductDetailsById()),
				() -> model.addAttribute("ProductDetails", new ArrayList<ProductDetail>()));
		if (action.equals("update")) {
			productDetailService.getProductDetailById(detailId).ifPresentOrElse(
					pd -> {
						model.addAttribute("productDetailForm", pd);
					},
					() -> model.addAttribute("productDetailForm", new ProductDetail()));
			model.addAttribute("Sizes", sizeService.getAllSize().get());
			model.addAttribute("Colors", colorService.getAllColor().get());
		} else if (action.equals("add")) {
			model.addAttribute("productDetailForm", new ProductDetail());
			model.addAttribute("Sizes", sizeService.getAllSize().get());
			model.addAttribute("Colors", colorService.getAllColor().get());
		}
		return "adminTable";
	}

	@GetMapping("/category")
	public String category(ModelMap model) {

		model.addAttribute("model", Category.class.getSimpleName());
		System.out.println(Category.class.getSimpleName());
		model.addAttribute("listObject", categoryService.getAllCategory().get());
		return "adminTable";
	}

	@GetMapping("/size")
	public String size(ModelMap model) {

		model.addAttribute("model", Size.class.getSimpleName());
		System.out.println(Size.class.getSimpleName());
		model.addAttribute("listObject", sizeService.getAllSize().get());
		return "adminTable";
	}

	@GetMapping("/color")
	public String color(ModelMap model) {

		model.addAttribute("model", Color.class.getSimpleName());
		System.out.println(Color.class.getSimpleName());
		model.addAttribute("listObject", colorService.getAllColor().get());
		return "adminTable";
	}

}
