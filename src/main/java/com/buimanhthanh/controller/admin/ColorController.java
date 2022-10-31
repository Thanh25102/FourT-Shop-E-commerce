package com.buimanhthanh.controller.admin;

import com.buimanhthanh.dto.ColorDTO;
import com.buimanhthanh.entity.Color;
import com.buimanhthanh.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class ColorController {
    @Autowired
    private ColorService colorService;

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

    @PostMapping("/color")
    public String color(ModelMap model, @ModelAttribute("color") @Valid ColorDTO color, BindingResult result) {
        if (result.hasErrors())
            return "redirect:/admin/color?action=add";
        else {
            colorService.saveOrUpdateColor(color);
            return "redirect:/admin/color";
        }
    }

    @PostMapping("/color/edit/{id}")
    public String updateColor(ModelMap model, @ModelAttribute("color") @Valid ColorDTO color, BindingResult result,
                              @PathVariable(required = true) Integer id) {
        if (result.hasErrors())
            return "redirect:/admin/color?action=update&&id=" + id;
        else {
            colorService.saveOrUpdateColor(color);
            return "redirect:/admin/color";
        }
    }
}
