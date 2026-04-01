package com.mo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = LoanProductValidator.class)
public @interface ValidateLoanProductType {
    String message() default "Invalid loan product configuration";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
