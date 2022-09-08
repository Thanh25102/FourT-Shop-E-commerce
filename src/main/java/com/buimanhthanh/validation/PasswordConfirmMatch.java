package com.buimanhthanh.validation;

import com.buimanhthanh.validation.impl.PasswordConfirmMatchValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PasswordConfirmMatchValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordConfirmMatch {

    public String message()  default "Password incorrect";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
