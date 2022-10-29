package com.buimanhthanh.controller.admin;

import com.buimanhthanh.entity.Discount;
import com.buimanhthanh.entity.Product;
import com.buimanhthanh.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("/admin")
public class DiscountController {
    @Autowired
    private DiscountService discountService;
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
}
