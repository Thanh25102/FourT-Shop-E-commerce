package com.buimanhthanh.controller.admin;

import com.buimanhthanh.entity.*;
import com.buimanhthanh.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@GetMapping(value = {"/",""})
	public String index() {
		return "adminIndex";
	}
	@GetMapping("/table")
	public String table() {
		return "adminTable";
	}
}
