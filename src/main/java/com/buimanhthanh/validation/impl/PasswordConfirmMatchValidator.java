package com.buimanhthanh.validation.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.buimanhthanh.entity.Account;
import com.buimanhthanh.validation.PasswordConfirmMatch;

public class PasswordConfirmMatchValidator implements ConstraintValidator<PasswordConfirmMatch, Account>{

	
	@Override
	public boolean isValid(Account account, ConstraintValidatorContext context) {
		
		return account.getPassword().equals(account.getPasswordConfirm());
	}

}
