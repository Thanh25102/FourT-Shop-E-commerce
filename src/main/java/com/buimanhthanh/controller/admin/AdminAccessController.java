package com.buimanhthanh.controller.admin;

import com.buimanhthanh.entity.Access;
import com.buimanhthanh.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminAccessController {
    @Autowired
    private AccessService accessService;
    @GetMapping("/access")
    public String access(ModelMap model) {
        model.addAttribute("model", Access.class.getSimpleName());
        model.addAttribute("listObject", accessService.getAllAccess().get());
        return "adminTable";
    }
}
