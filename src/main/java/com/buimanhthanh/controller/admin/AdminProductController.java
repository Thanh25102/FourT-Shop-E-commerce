package com.buimanhthanh.controller.admin;

import com.buimanhthanh.dto.ProductDTO;
import com.buimanhthanh.dto.ProductDetailDTO;
import com.buimanhthanh.entity.Category;
import com.buimanhthanh.entity.Product;
import com.buimanhthanh.entity.ProductDetail;
import com.buimanhthanh.service.*;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductDetailService productDetailService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private SizeService sizeService;
	@Autowired
	private ColorService colorService;

	@Autowired
	private Cloudinary cloudinary;

	@GetMapping("/product")
	public String product(ModelMap model, @RequestParam(required = false, defaultValue = "-1") Integer id,
			@RequestParam(required = false, defaultValue = "null") String action) {
		model.addAttribute("model", Product.class.getSimpleName());

		if (action.equals("update")) {
			productService.getProductById(id).ifPresentOrElse(p -> model.addAttribute("Product", p),
					() -> model.addAttribute("Product", new ProductDTO()));
			categoryService.getAllCategory().ifPresentOrElse(c -> model.addAttribute("Categories", c),
					() -> model.addAttribute("Categories", new ArrayList<Category>()));
		} else if (action.equals("add")) {
			model.addAttribute("Product", new ProductDTO());
			categoryService.getAllCategory().ifPresentOrElse(c -> model.addAttribute("Categories", c),
					() -> model.addAttribute("Categories", new ArrayList<Category>()));
		}

		model.addAttribute("listObject", productService.getAllProduct().get());

		return "adminTable";
	}

	@PostMapping("/product/edit/{id}")
	public String product(@PathVariable(required = true) Integer id,
			@ModelAttribute("Product") @Valid ProductDTO product, BindingResult result) {
		if (result.hasErrors())
			return "redirect:/admin/product?action=update&&id=" + id;
		else if (!product.getFile().isEmpty()) {
			try {
				Map r = cloudinary.uploader().upload(product.getFile().getBytes(),
						ObjectUtils.asMap("resource_type", "auto"));
				product.setRepresent(r.get("secure_url").toString());

				productService.saveOrUpdateProduct(product);
				return "redirect:/admin/product";
			} catch (IOException e) {
				e.printStackTrace();
				return "redirect:/admin/product?action=update&&id=" + id;
			}
		} else {
			productService.saveOrUpdateProduct(product);
			return "redirect:/admin/product";
		}
	}

	@PostMapping("/product/add")
	public String addProduct(@ModelAttribute("Product") @Valid ProductDTO product, BindingResult result) {
		if (result.hasErrors())
			return "redirect:/admin/product?action=add";
		else if (!product.getFile().isEmpty()) {
			try {
				Map r = cloudinary.uploader().upload(product.getFile().getBytes(),
						ObjectUtils.asMap("resource_type", "auto"));
				product.setRepresent(r.get("secure_url").toString());
				productService.saveOrUpdateProduct(product);
				return "redirect:/admin/product";
			} catch (IOException e) {
				e.printStackTrace();
				return "redirect:/admin/product?action=add";
			}
		} else {
			productService.saveOrUpdateProduct(product);
			return "redirect:/admin/product";
		}
	}

	@PostMapping("/product/delete/{id}")
	public String deleteProduct(ModelMap model, @PathVariable(required = true) Integer id) {
		productService.deleteProduct(id);
		return "redirect:/admin/product";
	}

	@GetMapping("/product/detail/{id}")
	public String productDetailByProduct(ModelMap model, @PathVariable Integer id,
			@RequestParam(required = false, defaultValue = "-1") Integer detailId,
			@RequestParam(required = false, defaultValue = "null") String action) {
		model.addAttribute("model", ProductDetail.class.getSimpleName());
		model.addAttribute("back", Product.class.getSimpleName());
		model.addAttribute("pathVariable", id);

		productDetailService.getProductDetailByProductId(id).ifPresentOrElse(
				p -> model.addAttribute("ProductDetails", p),
				() -> model.addAttribute("ProductDetails", new ArrayList<ProductDetailDTO>()));
		if (action.equals("update")) {
			productDetailService.getProductDetailById(detailId).ifPresentOrElse(pd -> {
				model.addAttribute("productDetailForm", pd);
			}, () -> model.addAttribute("productDetailForm", new ProductDetailDTO()));
			model.addAttribute("Sizes", sizeService.getAllSize().get());
			model.addAttribute("Colors", colorService.getAllColor().get());
		} else if (action.equals("add")) {
			model.addAttribute("productDetailForm", new ProductDetailDTO());
			model.addAttribute("Sizes", sizeService.getAllSize().get());
			model.addAttribute("Colors", colorService.getAllColor().get());
		}
		return "adminTable";
	}

	@GetMapping("/product-detail/{id}")
	public String productDetail(ModelMap model, @PathVariable Integer id,
			@RequestParam(required = false, defaultValue = "null") String action) {
		model.addAttribute("model", ProductDetail.class.getSimpleName());
		ProductDetailDTO productDetailDTO = productDetailService.getProductDetailById(id).get();
		model.addAttribute("ProductDetails", List.of(productDetailDTO));
		if (action.equals("update")) {
			model.addAttribute("productDetailForm", productDetailDTO);
			model.addAttribute("Sizes", sizeService.getAllSize().get());
			model.addAttribute("Colors", colorService.getAllColor().get());
		} else if (action.equals("add")) {
			model.addAttribute("productDetailForm", new ProductDetailDTO());
			model.addAttribute("Sizes", sizeService.getAllSize().get());
			model.addAttribute("Colors", colorService.getAllColor().get());
		}
		return "adminTable";
	}

	@PostMapping("/product/detail/{id}/edit/{detailId}")
	public String updateProductDetail(@ModelAttribute("productDetailForm") @Valid ProductDetailDTO productDetailDTO,
			BindingResult result, @PathVariable(required = true) Integer id,
			@PathVariable(required = true) Integer detailId) {
		if (result.hasErrors()) {
			return "redirect:/admin/product/detail/" + id + "?action=update&&detailId=" + detailId;
		} else {
			productDetailService.saveOrUpdateProductDetail(productDetailDTO);
			return "redirect:/admin/product/detail/" + id;
		}
	}

	@PostMapping("/product/detail/{id}/add")
	public String addProductDetail(@ModelAttribute("productDetailForm") @Valid ProductDetailDTO productDetailDTO,
			BindingResult result, @PathVariable(required = true) Integer id) {
		if (result.hasErrors()) {
			return "redirect:/admin/product/detail/" + id + "?action=add";
		} else {
			productDetailService.saveOrUpdateProductDetail(productDetailDTO);
			return "redirect:/admin/product/detail/" + id;
		}
	}

	@PostMapping("/product/detail/delete/{id}")
	public void productDetail(@PathVariable(required = true) Integer id) {
		productDetailService.deleteProductDetail(id);
	}
}
