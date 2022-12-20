package com.buimanhthanh.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@ModelAttribute
	public void commonAttrs(ModelMap modelMap, HttpSession session) {
		modelMap.addAttribute("currentUser", session.getAttribute("currentUser"));
	}

	@GetMapping(value = { "/", "" })
	public String index() {
		return "adminIndex";
	}

	@GetMapping("/table")
	public String table() {
		return "adminTable";
	}
}
