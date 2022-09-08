package com.buimanhthanh.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.buimanhthanh.validation.impl.UsernameExistValidator;

@Constraint(validatedBy = UsernameExistValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UsernameExist {

    public String message()  default "Username has already exist";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};

}
