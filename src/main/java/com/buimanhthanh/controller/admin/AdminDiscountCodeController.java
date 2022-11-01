package com.buimanhthanh.controller.admin;

import com.buimanhthanh.dto.DiscountCodeDTO;
import com.buimanhthanh.entity.DiscountCode;
import com.buimanhthanh.service.DiscountCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminDiscountCodeController {

    @Autowired
    private DiscountCodeService discountCodeService;
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

    @PostMapping("/discount_code")
    public String discountCode(ModelMap model, @ModelAttribute("DiscountCode") @Valid DiscountCodeDTO discountCode,
                               BindingResult result) {
        if (result.hasErrors())
            return "redirect:/admin/discount_code?action=add";
        else {
            discountCodeService.saveOrUpdateDiscountCode(discountCode);
            return "redirect:/admin/discount_code";
        }
    }

    @PostMapping("/discount_code/edit/{id}")
    public String updateDiscountCode(ModelMap model, @ModelAttribute("DiscountCode") @Valid DiscountCodeDTO discountCode,
                                     BindingResult result, @PathVariable Integer id) {
        if (result.hasErrors())
            return "redirect:/admin/discount_code?action=update&&id=" + id;
        else {
            discountCodeService.saveOrUpdateDiscountCode(discountCode);
            return "redirect:/admin/discount_code";
        }
    }
}
