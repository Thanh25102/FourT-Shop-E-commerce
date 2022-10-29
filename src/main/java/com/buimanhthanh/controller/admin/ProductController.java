package com.buimanhthanh.controller.admin;

import com.buimanhthanh.entity.Category;
import com.buimanhthanh.entity.Product;
import com.buimanhthanh.entity.ProductDetail;
import com.buimanhthanh.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

public class ProductController {
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

}
