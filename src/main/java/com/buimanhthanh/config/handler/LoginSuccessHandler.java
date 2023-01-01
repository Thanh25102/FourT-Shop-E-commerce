package com.buimanhthanh.config.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.buimanhthanh.dto.AccountDTO;
import com.buimanhthanh.service.AccountService;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired private AccountService userDetailService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
       AccountDTO accountDTO = this.userDetailService.getAccountByUsername(authentication.getName()).get();
       request.getSession().setAttribute("currentUser",accountDTO);
       String rootPath = request.getContextPath();
       System.out.println(rootPath);
       response.sendRedirect(rootPath);
    }
}
