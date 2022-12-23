package com.buimanhthanh.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buimanhthanh.dto.RevenueDTO;
import com.buimanhthanh.exporter.AccountExporter;
import com.buimanhthanh.exporter.IExporter;
import com.buimanhthanh.exporter.ProductExporter;
import com.buimanhthanh.exporter.RevenueExporter;
import com.buimanhthanh.service.AccountService;
import com.buimanhthanh.service.OrderService;
import com.buimanhthanh.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private ProductService productService;

	@ModelAttribute
	public void commonAttrs(ModelMap modelMap, HttpSession session) {
		modelMap.addAttribute("currentUser", session.getAttribute("currentUser"));
	}

	@GetMapping(value = { "/", "" })
	public String index(ModelMap model) {
		int deliveringNumber = orderService.getAllOrderDelevering().size();
		int pendingNumber = orderService.getAllOrderPending().size();
		int completeNumber = orderService.getAllOrderComplete().size();

		float tasks = (deliveringNumber * 100) / (1.0f * (deliveringNumber + pendingNumber));
		System.out.println((deliveringNumber + " " + pendingNumber));
		model.addAttribute("earningMonth", orderService.getEarningMonth());
		model.addAttribute("earning", orderService.getEarning());
		model.addAttribute("pending", pendingNumber);
		model.addAttribute("deliveringNumber", deliveringNumber);
		model.addAttribute("completeNumber", completeNumber);
		model.addAttribute("tasks", tasks);
		ObjectMapper mapper = new ObjectMapper();
		try {
			model.addAttribute("revenues", mapper.writeValueAsString(orderService.getEarningYear()));

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "adminIndex";
	}

	@GetMapping(value = { "/last-year" })
	public String indexLastYear(ModelMap model) {
		int deliveringNumber = orderService.getAllOrderDelevering().size();
		int pendingNumber = orderService.getAllOrderPending().size();
		int completeNumber = orderService.getAllOrderComplete().size();

		float tasks = (deliveringNumber * 100) / (1.0f * (deliveringNumber + pendingNumber));
		System.out.println((deliveringNumber + " " + pendingNumber));
		model.addAttribute("earningMonth", orderService.getEarningMonth());
		model.addAttribute("earning", orderService.getEarning());
		model.addAttribute("pending", pendingNumber);
		model.addAttribute("deliveringNumber", deliveringNumber);
		model.addAttribute("completeNumber", completeNumber);
		model.addAttribute("tasks", tasks);
		ObjectMapper mapper = new ObjectMapper();
		try {
			model.addAttribute("revenues", mapper.writeValueAsString(orderService.getEarningLastYear()));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "adminIndex";
	}

	@GetMapping("/table")
	public String table() {
		return "adminTable";
	}

	@GetMapping("/export-revenue-excel")
	@ResponseBody
	public void exportRevenue(@RequestParam(name = "filename", defaultValue = "revenue") String filename,@RequestParam(name = "model", defaultValue = "revenue") String model,
			HttpServletResponse response) {
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachement; filename=" + filename + ".xlsx";
		response.setHeader(headerKey, headerValue);

		IExporter excel = null;
		switch (model) {
		case "revenue":
			excel = new RevenueExporter(orderService.getEarningYear(),orderService.getAllOrderComplete());
			break;
		case "Account":
			excel = new AccountExporter(accountService.getAllAccount().get());
			break;
		case "Product":
			excel = new ProductExporter(productService.getAllProduct().get());
			break;
		default:
			break;
		} 
		try {
			excel.export(response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
