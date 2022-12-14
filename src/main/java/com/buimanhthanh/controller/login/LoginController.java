package com.buimanhthanh.controller.login;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.buimanhthanh.dto.AccountDTO;
import com.buimanhthanh.service.AccountService;

@Controller
@RequestMapping("")
public class LoginController {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private AccountService userDetailService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register(ModelMap modelMap) {
		modelMap.addAttribute("userRegister", new AccountDTO());
		return "register";
	}

	@PostMapping(value = { "/register" })
	public String register(@ModelAttribute(value = "userRegister") @Valid AccountDTO accountDTO, BindingResult result,
			ModelMap modelMap) throws InterruptedException, ExecutionException {
		Optional<AccountDTO> optionalAccount = userDetailService.getAccountByUsername(accountDTO.getUsername());

		optionalAccount.ifPresent(a -> result.addError(new ObjectError("username",
				messageSource.getMessage("account.username.err.exist", null, "username has already exists :D", null))));
		userDetailService.getAccountByEmail(accountDTO.getEmail()).ifPresent(a -> result.addError(new ObjectError(
				"email",
				messageSource.getMessage("account.email.err.exist", null, "email has already exists :D", null))));

		if (result.hasErrors() || optionalAccount.isPresent())
			return "register";
		return userDetailService.registerAccount(accountDTO) ? "redirect:/" : "register";
	}

}
