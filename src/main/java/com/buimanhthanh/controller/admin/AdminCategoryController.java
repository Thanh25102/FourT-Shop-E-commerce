package com.buimanhthanh.controller.admin;

import com.buimanhthanh.dto.CategoryDTO;
import com.buimanhthanh.entity.Category;
import com.buimanhthanh.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminCategoryController {
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/category")
	public String category(ModelMap model, @RequestParam(required = false, defaultValue = "-1") Integer id,
			@RequestParam(required = false, defaultValue = "null") String action) {

		if (action.equals("update")) {
			categoryService.getCategoryById(id).ifPresentOrElse(c -> model.addAttribute("Category", c),
					() -> model.addAttribute("Category", new Category()));
		} else if (action.equals("add")) {
			model.addAttribute("Category", new Category());
		}
		model.addAttribute("model", Category.class.getSimpleName());
		model.addAttribute("listObject", categoryService.getAllCategory().get());
		return "adminTable";
	}

	@PostMapping("/category")
	public String category(ModelMap model, @ModelAttribute("Category") @Valid CategoryDTO category,
			BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/admin/category?action=add";
		} else {
			categoryService.saveOrUpdateCategory(category);
			return "redirect:/admin/category";
		}
	}

	@PostMapping("/category/edit/{id}")
	public String updateCategory(ModelMap model, @ModelAttribute("Category") @Valid CategoryDTO category,
			BindingResult result, @PathVariable(required = true) Integer id) {
		if (result.hasErrors()) {
			return "redirect:/admin/category?action=update&&id=" + id;
		} else {
			categoryService.saveOrUpdateCategory(category);
			return "redirect:/admin/category";
		}
	}

}
