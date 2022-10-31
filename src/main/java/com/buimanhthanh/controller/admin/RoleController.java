package com.buimanhthanh.controller.admin;

import com.buimanhthanh.dto.RoleDTO;
import com.buimanhthanh.entity.Role;
import com.buimanhthanh.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/role")
    public String role(ModelMap model, @ModelAttribute("role") @Valid RoleDTO role, BindingResult result) {
        if (result.hasErrors())
            return "adminTable";
        else {
            roleService.saveOrUpdateRole(role);
            return "redirect:/role";
        }
    }

    @GetMapping("/role")
    public String role(ModelMap model) {
        model.addAttribute("model", Role.class.getSimpleName());
        System.out.println(Role.class.getSimpleName());
        model.addAttribute("listObject", roleService.getAllRole().get());
        return "adminTable";
    }
}
