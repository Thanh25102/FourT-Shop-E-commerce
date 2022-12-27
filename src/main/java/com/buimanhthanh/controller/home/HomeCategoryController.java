package com.buimanhthanh.controller.home;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.buimanhthanh.dto.CategoryRangeDTO;
import com.buimanhthanh.dto.PriceRange;
import com.buimanhthanh.dto.ProductDTO;
import com.buimanhthanh.dto.ProductUrlBuilder;
import com.buimanhthanh.enumration.SortType;
import com.buimanhthanh.service.CategoryService;
import com.buimanhthanh.service.ProductService;

@Controller
@RequestMapping("")
public class HomeCategoryController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;

	private static final int PAGING = 8;

	@ModelAttribute
	public void category(ModelMap modelMap) {
		List<CategoryRangeDTO> categoryRanges = categoryService.getCategoryRange().get();
		int totalProduct = 0;
		for (CategoryRangeDTO categoryRange : categoryRanges) {
			totalProduct += categoryRange.getRange();
		}
		modelMap.addAttribute("categories", categoryService.getAllCategory().get());
		modelMap.addAttribute("categoryRanges", categoryRanges);
		modelMap.addAttribute("allCategoryRanges", totalProduct);
	}

	@GetMapping(value = { "/category/page/{page}/category/{category}/sort/{field}/{type}/limit/{limit}",
			"/category/page/{page}/category/{category}/sort/{field}/{type}",
			"/category/page/{page}/category/{category}", "/category/page/{page}/category/{category}/limit/{limit}",
			"/category/page/{page}", "/category" })
	public String category2PageCategorySort(ModelMap model, RedirectAttributes redirect, HttpServletRequest request,
			@PathVariable(required = false) Integer page, @PathVariable(required = false) Integer category,
			@PathVariable(required = false) String field, @PathVariable(required = false) String type,
			@PathVariable(name = "limit", required = false) Integer limit,
			@RequestParam(required = false, defaultValue = "-1") Double priceStart,
			@RequestParam(required = false, defaultValue = "-1") Double priceEnd) {
		if (limit == null) {
			limit = PAGING;
		}
		if (category == null) {
			category = 0;
		}
		if (page == null) {
			page = 1;
		}

		SortType sortType = SortType.ASC.getValue().equals(type) ? SortType.ASC : SortType.DESC;
		PriceRange priceRange = null;
		if (priceStart != -1 && priceEnd != -1) {
			priceRange = new PriceRange(priceStart, priceEnd);
		}
		List<ProductDTO> products = productService.getAllProduct(page, limit, category, field, sortType, priceRange)
				.get();

		model.addAttribute("products", products);
		ProductUrlBuilder productUrlBuilder = setUpBuild(request, page, limit, category, field, sortType, priceStart,
				priceEnd, model, products);
		model.addAttribute("productUrlBuilder", productUrlBuilder);

		Calendar calendar = Calendar.getInstance();
		Date currentDate = calendar.getTime();
		System.out.println(currentDate);
		products.forEach(p -> System.out.println(p));
		return "category";
	}

	private ProductUrlBuilder setUpBuild(HttpServletRequest request, Integer page, Integer limit, Integer categoryId,
			String orderBy, SortType sortType, Double priceStart, Double priceEnd, ModelMap modelMap,
			List<ProductDTO> products) {
		PriceRange priceRange = null;
		if (priceStart != -1 && priceEnd != -1) {
			priceRange = new PriceRange(priceStart, priceEnd);
		}
		Long allProducts = productService.getCountAllProduct(page, limit, categoryId, orderBy, sortType, priceRange);
		Double totalPage = Math.ceil((double) allProducts / limit);
		modelMap.addAttribute("pages", totalPage.intValue());
		ProductUrlBuilder productUrlBuilder = ProductUrlBuilder.builder().requestURI("/category").page(page)
				.limit(limit).categoryId(categoryId).orderBy(orderBy).sortType(sortType.getValue())
				.priceStart(priceStart).priceEnd(priceEnd).build();
		return productUrlBuilder;
	}
}
