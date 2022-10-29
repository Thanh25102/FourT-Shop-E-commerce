package com.buimanhthanh.controller.admin;

import com.buimanhthanh.entity.Size;
import com.buimanhthanh.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class SizeController {
    @Autowired
    private SizeService sizeService;
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
}
