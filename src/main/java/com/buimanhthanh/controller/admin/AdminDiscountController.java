package com.buimanhthanh.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.buimanhthanh.dto.DiscountDTO;
import com.buimanhthanh.entity.Discount;
import com.buimanhthanh.service.DiscountService;

@Controller
@RequestMapping("/admin")
public class AdminDiscountController {
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

//    @GetMapping("/discount/{id}/product")
//    public String productByDiscount(ModelMap model, @PathVariable(required = true) Integer id) {
//        model.addAttribute("model", Product.class.getSimpleName());
//        model.addAttribute("discountProduct", "discountProduct");
//        discountService.getDiscountById(id).ifPresentOrElse(p -> model.addAttribute("listObject", p.getProductsById()),
//                () -> model.addAttribute("listObject", new ArrayList<Product>()));
//        return "adminTable";
//    }


    @PostMapping("/discount")
    public String discount(ModelMap model, @ModelAttribute("discount") @Valid DiscountDTO discount, BindingResult result) {
        if (result.hasErrors())
            return "redirect:/admin/discount?action=add";
        else {
            discountService.saveOrUpdateDiscount(discount);
            return "redirect:/admin/discount";
        }
    }

    @PostMapping("/discount/edit/{id}")
    public String updateDiscount(ModelMap model, @ModelAttribute("Discount") @Valid DiscountDTO discount,
                                 BindingResult result, @PathVariable Integer id) {
        if (result.hasErrors())
            return "redirect:/admin/discount?action=update&&id="+id;
        else {
            discountService.saveOrUpdateDiscount(discount);
            return "redirect:/admin/discount";
        }
    }
}
