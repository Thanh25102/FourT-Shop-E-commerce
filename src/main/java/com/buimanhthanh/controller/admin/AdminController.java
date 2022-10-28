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
import java.util.List;

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
	@Autowired
	private PermissionService permissionService;
	
	@GetMapping(value = {"/",""})
	public String index() {
		return "adminIndex";
	}

	@GetMapping("/table")
	public String table() {
		return "adminTable";
	}

	@GetMapping("/account")
	public String account(ModelMap model, @RequestParam(required = false, defaultValue = "null") String action,
			@RequestParam(required = false, defaultValue = "null") String username) {
		if (action.equals("update")) {
			userDetailService.getAccountByUsername(username).ifPresentOrElse(a -> {
				model.addAttribute("Account", a);
				model.addAttribute("password", a.getPassword());
			}, () -> model.addAttribute("Account", new Account()));
			roleService.getAllRole().ifPresentOrElse(r -> model.addAttribute("Roles", r),
					() -> model.addAttribute("Roles", new ArrayList<Role>()));
		} else if (action.equals("add")) {
			model.addAttribute("Account", new Account());
			roleService.getAllRole().ifPresentOrElse(r -> model.addAttribute("Roles", r),
					() -> model.addAttribute("Roles", new ArrayList<Role>()));
		}
		model.addAttribute("model", Account.class.getSimpleName());
		model.addAttribute("listObject", userDetailService.getAllAccount().get());
		return "adminTable";
	}

	@GetMapping("/discount_code")
	public String discountCode(ModelMap model, @RequestParam(required = false, defaultValue = "null") String action,
			@RequestParam(required = false, defaultValue = "-1") Integer id) {
		if (action.equals("update")) {
			discountCodeService.getDiscountCodeById(id).ifPresentOrElse(dc -> model.addAttribute("DiscountCode", dc),
					() -> model.addAttribute("DiscountCode", new DiscountCode()));
		} else if (action.equals("add")) {
			model.addAttribute("DiscountCode", new DiscountCode());
		}
		model.addAttribute("model", DiscountCode.class.getSimpleName());
		model.addAttribute("listObject", discountCodeService.getAllDiscountCode().get());
		return "adminTable";
	}

	@GetMapping("/discount")
	public String discount(ModelMap model, @RequestParam(required = false, defaultValue = "null") String action,
			@RequestParam(required = false, defaultValue = "-1") Integer id) {
		if (action.equals("update")) {
			discountService.getDiscountById(id).ifPresentOrElse(d -> model.addAttribute("Discount", d),
					() -> model.addAttribute("Discount", new Discount()));
		} else if (action.equals("add")) {
			model.addAttribute("Discount", new Discount());
		}
		model.addAttribute("model", Discount.class.getSimpleName());
		model.addAttribute("listObject", discountService.getAllDiscount().get());
		return "adminTable";
	}

	@GetMapping("/discount/{id}/product")
	public String productByDiscount(ModelMap model, @PathVariable(required = true) Integer id) {
		model.addAttribute("model", Product.class.getSimpleName());
		model.addAttribute("discountProduct", "discountProduct");
		discountService.getDiscountById(id).ifPresentOrElse(p -> model.addAttribute("listObject", p.getProductsById()),
				() -> model.addAttribute("listObject", new ArrayList<Product>()));
		return "adminTable";
	}

	@GetMapping("/role")
	public String role(ModelMap model) {
		model.addAttribute("model", Role.class.getSimpleName());
		System.out.println(Role.class.getSimpleName());
		model.addAttribute("listObject", roleService.getAllRole().get());
		return "adminTable";
	}
	
	/*
	 * @GetMapping("/role/{id}/access") public String accessByRole(ModelMap
	 * model, @PathVariable(required = true) Integer id) {
	 * model.addAttribute("model", Access.class.getSimpleName());
	 * permissionService.getPermissionByRoleId(id).ifPresentOrElse(permission -> {
	 * List<Access> listObject = new ArrayList<>(); permission.forEach(p->
	 * listObject.add(p.getAccessByAccessId())); model.addAttribute("listObject",
	 * listObject); }, () -> model.addAttribute("listObject", new
	 * ArrayList<Access>())); return "adminTable"; }
	 */

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

	@GetMapping("/order/detail/{id}")
	public String orderDetail(ModelMap model, @PathVariable(required = true, name = "id") Integer id) {
		model.addAttribute("model", OrderDetail.class.getSimpleName());
		orderService.getOrderById(id).ifPresentOrElse(o -> model.addAttribute("listObject", o.getOrderDetailsById()),
				() -> model.addAttribute("listObject", new ArrayList<OrderDetail>()));
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

	@GetMapping("/product/detail/{id}")
	public String productDetailByProduct(ModelMap model, @PathVariable Integer id,
			@RequestParam(required = false, defaultValue = "-1") Integer detailId,
			@RequestParam(required = false, defaultValue = "null") String action) {
		model.addAttribute("model", ProductDetail.class.getSimpleName());
		model.addAttribute("back", Product.class.getSimpleName());
		model.addAttribute("pathVariable", id);
		productService.getProductById(id).ifPresentOrElse(
				p -> model.addAttribute("ProductDetails", p.getProductDetailsById()),
				() -> model.addAttribute("ProductDetails", new ArrayList<ProductDetail>()));
		if (action.equals("update")) {
			productDetailService.getProductDetailById(detailId).ifPresentOrElse(pd -> {
				model.addAttribute("productDetailForm", pd);
			}, () -> model.addAttribute("productDetailForm", new ProductDetail()));
			model.addAttribute("Sizes", sizeService.getAllSize().get());
			model.addAttribute("Colors", colorService.getAllColor().get());
		} else if (action.equals("add")) {
			model.addAttribute("productDetailForm", new ProductDetail());
			model.addAttribute("Sizes", sizeService.getAllSize().get());
			model.addAttribute("Colors", colorService.getAllColor().get());
		}
		return "adminTable";
	}

	@GetMapping("/product-detail/{id}")
	public String productDetail(ModelMap model, @PathVariable Integer id,
			@RequestParam(required = false, defaultValue = "null") String action) {
		model.addAttribute("model", ProductDetail.class.getSimpleName());
		ProductDetail l = productDetailService.getProductDetailById(id).get();
		model.addAttribute("ProductDetails", List.of(l));
		if (action.equals("update")) {
			model.addAttribute("productDetailForm", l);
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
	public String category(ModelMap model, @RequestParam(required = false, defaultValue = "-1") Integer id,
			@RequestParam(required = false, defaultValue = "null") String action) {

		if (action.equals("update")) {
			categoryService.getCategoryById(id).ifPresentOrElse(c -> model.addAttribute("Category", c),
					() -> model.addAttribute("Category", new Category()));
		} else if (action.equals("add")) {
			model.addAttribute("Category", new Category());
		}
		model.addAttribute("model", Category.class.getSimpleName());
		model.addAttribute("listObject", categoryService.getAllCategory().get());
		return "adminTable";
	}

	@GetMapping("/size")
	public String size(ModelMap model, @RequestParam(required = false, defaultValue = "-1") Integer id,
			@RequestParam(required = false, defaultValue = "null") String action) {
		if (action.equals("update")) {
			sizeService.getSizeById(id).ifPresentOrElse(s -> model.addAttribute("Size", s),
					() -> model.addAttribute("Size", new Size()));
		} else if (action.equals("add")) {
			model.addAttribute("Size", new Size());
		}
		model.addAttribute("model", Size.class.getSimpleName());
		model.addAttribute("listObject", sizeService.getAllSize().get());
		return "adminTable";
	}

	@GetMapping("/color")
	public String color(ModelMap model, @RequestParam(required = false, defaultValue = "-1") Integer id,
			@RequestParam(required = false, defaultValue = "null") String action) {
		if (action.equals("update")) {
			colorService.getColorById(id).ifPresentOrElse(c -> model.addAttribute("Color", c),
					() -> model.addAttribute("Color", new Color()));
		} else if (action.equals("add")) {
			model.addAttribute("Color", new Color());
		}
		model.addAttribute("model", Color.class.getSimpleName());
		model.addAttribute("listObject", colorService.getAllColor().get());
		return "adminTable";
	}

}
