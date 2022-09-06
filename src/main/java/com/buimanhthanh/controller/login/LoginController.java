package com.buimanhthanh.controller.login;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.buimanhthanh.entity.Account;
import com.buimanhthanh.service.AccountService;
import com.buimanhthanh.service.RoleService;

@Controller
public class LoginController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private RoleService roleService;
	
    @GetMapping("/login")
    public String login(){
    	return "login";
    }
    
    @GetMapping("/register")
    public String register(ModelMap modelMap) {
    	modelMap.addAttribute("userRegister", new Account());
    	return "register";
    }
    
    @PostMapping(value = { "/register" })
	public String register(@ModelAttribute(value = "userRegister") @Valid Account account, BindingResult result,
			ModelMap modelMap) {
    	account.setEnabled4(true);
    	account.setRankAccount("MEMBER");
    	account.setRoleById(roleService.getRoleByAuthority("CUSTOMER").get());
		return accountService.registerAccount(account) ? "redirect:/index" : "register";
	}
}
