package com.buimanhthanh.validation.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.buimanhthanh.service.AccountService;
import com.buimanhthanh.validation.UsernameExist;

public class UsernameExistValidator implements ConstraintValidator<UsernameExist, String>{

	@Autowired
	private AccountService userDetailService;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		try{
			boolean a = userDetailService.getAccountByUsername(value).isEmpty();
			return a;
		}catch(Exception e) {
			System.out.println("----------------------------------------");
			System.out.println(e);
			e.printStackTrace();
		}
		return false;
	}

}
