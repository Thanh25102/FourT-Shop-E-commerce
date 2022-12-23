package com.buimanhthanh.controller.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.buimanhthanh.service.ProductService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class HomeController {

	@Autowired
	private ProductService productService;

	@ModelAttribute
	public void commonAttrs(ModelMap modelMap, HttpSession session) {
		modelMap.addAttribute("currentUser", session.getAttribute("currentUser"));
	}

	@GetMapping(value = {"/"})
	public String index(ModelMap modelMap, HttpSession session) {
		System.out.println("Tao nè thành");
		modelMap.addAttribute("lastestProducts", productService.getLatestProducts(8).get());
		return "index";
	}

	@GetMapping("/blog")
	public String blog() {
		System.out.println("Tao nè thành");
		return "blog";
	}

	@GetMapping("/single-blog")
	public String singleBlog() {
		return "singleBlog";
	}

	@GetMapping("/elements")
	public String elements() {
		return "elements";
	}
}
