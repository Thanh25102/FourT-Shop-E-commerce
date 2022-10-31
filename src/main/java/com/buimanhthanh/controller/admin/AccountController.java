package com.buimanhthanh.controller.admin;

import com.buimanhthanh.dto.AccountDTO;
import com.buimanhthanh.entity.Account;
import com.buimanhthanh.entity.Role;
import com.buimanhthanh.service.AccountService;
import com.buimanhthanh.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("/admin")
public class AccountController {

    @Autowired
    private AccountService userDetailService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/account")
    public String account(ModelMap model, @RequestParam(required = false, defaultValue = "null") String action,
                          @RequestParam(required = false, defaultValue = "null") String username) {
        if (action.equals("update")) {
            userDetailService.getAccountByUsername(username).ifPresentOrElse(a -> {
                model.addAttribute("Account", a);
                model.addAttribute("password", a.getPassword());
            }, () -> model.addAttribute("Account", new AccountDTO()));
            roleService.getAllRole().ifPresentOrElse(r -> model.addAttribute("Roles", r),
                    () -> model.addAttribute("Roles", new ArrayList<Role>()));
        } else if (action.equals("add")) {
            model.addAttribute("Account", new AccountDTO());
            roleService.getAllRole().ifPresentOrElse(r -> model.addAttribute("Roles", r),
                    () -> model.addAttribute("Roles", new ArrayList<Role>()));
        }
        model.addAttribute("model", Account.class.getSimpleName());
        model.addAttribute("listObject", userDetailService.getAllAccount().get());
        return "adminTable";
    }
    @PostMapping("/account")
    public String account(@ModelAttribute("Account") @Valid AccountDTO accountDTO,
                          BindingResult result) {
        userDetailService.getAccountByUsername(accountDTO.getUsername()).ifPresent(a -> result.addError(new ObjectError(
                "username",
                messageSource.getMessage("account.username.err.exist", null, "username has already exists :D", null))));
        userDetailService.getAccountByEmail(accountDTO.getEmail()).ifPresent(a -> result.addError(new ObjectError("email",
                messageSource.getMessage("account.email.err.exist", null, "email has already exists :D", null))));
        String passwordEncode = passwordEncoder.encode(accountDTO.getPassword());
        if (result.hasErrors() || !accountDTO.getPassword().equals(accountDTO.getPasswordConfirm())) {
            result.addError(new ObjectError("passwordConfirm", "password does not match"));
        } else {
            accountDTO.setPassword(passwordEncode);
            accountDTO.setPasswordConfirm(passwordEncode);
            userDetailService.saveOrUpdateAccount(accountDTO);
        }
        return "redirect:/admin/account";
    }

    @PostMapping("/account/edit/{username}")
    public String updateAccount(@ModelAttribute("Account") @Valid AccountDTO accountDTO,
                                BindingResult result,
                                @PathVariable String username) {
        if (result.hasErrors())
            return "redirect:/admin/account?action=update&&username=" + username;
        else {
            userDetailService.saveOrUpdateAccount(accountDTO);
            return "redirect:/admin/account";
        }
    }

    @GetMapping("/account/delete/{username}")
    public String disableAccount(@PathVariable(required = true) String username) {
        AccountDTO accountDTO = userDetailService.getAccountByUsername(username).get();
        accountDTO.setEnabled(false);
        accountDTO.setPasswordConfirm(accountDTO.getPassword());
        userDetailService.saveOrUpdateAccount(accountDTO);
        return "redirect:/admin/account";
    }


}
