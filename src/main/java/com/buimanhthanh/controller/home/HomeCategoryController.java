package com.buimanhthanh.controller.home;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@GetMapping("/category")
	public String category(ModelMap modelMap, @RequestParam(defaultValue = "1") Integer page, HttpServletRequest request,
			@RequestParam(defaultValue = "6") Integer limit, @RequestParam(defaultValue = "0") Integer categoryId,
			@RequestParam(defaultValue = "") String orderBy, @RequestParam(defaultValue = "ASC") String sortType,
			@RequestParam(defaultValue = "0") Double priceStart,
			@RequestParam(defaultValue = "99999999999") Double priceEnd) {

		List<ProductDTO> products = productService.getAllProduct(page, limit, categoryId, orderBy,
				sortType.equalsIgnoreCase(SortType.DESC.getValue()) ? SortType.DESC : SortType.ASC,
				new PriceRange(priceStart, priceEnd)).get();
		List<CategoryRangeDTO> listCategoryRangeDTO =  categoryService.getCategoryRange().get();
		Long allProducts = productService.getCountProductFormCategory();
		
		if(categoryId != 0) {
			for (CategoryRangeDTO categoryRangeDTO : listCategoryRangeDTO) {
				if(categoryRangeDTO.getCategoryId() == categoryId) {
					allProducts = categoryRangeDTO.getRange();
				}
			}
		}
		Double totalPage = Math.ceil((double)allProducts / limit);
		
		System.out.println(totalPage);
		ProductUrlBuilder productUrlBuilder = 
					ProductUrlBuilder.builder()
										.schema(request.getScheme()).servletName(request.getServerName())
										.serverPort(request.getServerPort()+"").requestURI(request.getRequestURI())
										.page(page).limit(limit).categoryId(categoryId).orderBy(orderBy)
										.sortType(sortType).priceStart(priceStart).priceEnd(priceEnd)
										.build();

		modelMap.addAttribute("url",productUrlBuilder);
		modelMap.addAttribute("pages", Math.ceil((double)products.size() / limit));;
		modelMap.addAttribute("totalPage", totalPage.intValue());
		modelMap.addAttribute("curPage", page);
		modelMap.addAttribute("products", products);
		modelMap.addAttribute("allProducts", allProducts);
		modelMap.addAttribute("categoryRanges",listCategoryRangeDTO);
		modelMap.addAttribute("categories", categoryService.getAllCategory().get());
		return "category";
	}
}
