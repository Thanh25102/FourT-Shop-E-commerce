package com.buimanhthanh.validation.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.buimanhthanh.dto.AccountDTO;
import com.buimanhthanh.validation.PasswordConfirmMatch;

public class PasswordConfirmMatchValidator implements ConstraintValidator<PasswordConfirmMatch, AccountDTO>{
	@Override
	public boolean isValid(AccountDTO value, ConstraintValidatorContext context) {
		return value.getPassword().equals(value.getPasswordConfirm());
	}
}
