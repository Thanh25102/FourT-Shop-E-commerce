package com.buimanhthanh.controller.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.buimanhthanh.dto.ColorDTO;
import com.buimanhthanh.dto.ProductDTO;
import com.buimanhthanh.dto.ProductDetailDTO;
import com.buimanhthanh.dto.SizeDTO;
import com.buimanhthanh.service.ColorService;
import com.buimanhthanh.service.ProductDetailService;
import com.buimanhthanh.service.ProductService;
import com.buimanhthanh.service.SizeService;

@Controller
@RequestMapping("")
public class HomeSingleProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductDetailService productDetailService;
	@Autowired
	private SizeService sizeService;
	@Autowired
	private ColorService colorService;

	@GetMapping("/product-detail/{id}")
	public String index(ModelMap modelMap, @PathVariable() Integer id) {
		ProductDTO productDTO = productService.getProductById(id).get();
		List<ProductDetailDTO> productDetailDTOs = productDetailService.getProductDetailByProductId(id).get();
		List<SizeDTO> sizeDTOs = sizeService.getAllSize().get();
		List<ColorDTO> colorDTOs = colorService.getAllColor().get();
		
		modelMap.addAttribute("product", productDTO);
		modelMap.addAttribute("productDetails", productDetailDTOs);
		modelMap.addAttribute("sizes", sizeDTOs);
		modelMap.addAttribute("colors", colorDTOs);
		return "productDetail";
	}
}
