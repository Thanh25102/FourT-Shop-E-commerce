package com.buimanhthanh.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class ConfirmationController {
    @GetMapping("/confirmation")
    public String confirmation() {
        return "confirmation";
    }
}
