package com.buimanhthanh.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/blog")
	public String blog() {
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
