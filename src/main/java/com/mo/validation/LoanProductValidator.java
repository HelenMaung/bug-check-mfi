package com.mo.validation;

import com.mo.dto.request.LoanProductRequestDto;
import com.mo.enums.CalculationType;
import com.mo.exception.CustomValidationException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.math.BigDecimal;

public class LoanProductValidator implements ConstraintValidator<ValidateLoanProductType, LoanProductRequestDto> {

    @Override
    public boolean isValid(LoanProductRequestDto dto, ConstraintValidatorContext context) {

        if(dto == null) {
            throw new CustomValidationException(
                    "LoanProduct",
                    "MISSING_OBJECT",
                    "Loan Product Request is empty"
            );
        }

        if(dto.getPrincipal() == null) {
            throw new CustomValidationException(
                    "Principal",
                    "MISSING_FIELD",
                    "Principal amount is required"
            );
        }

        if(dto.getAnnualRate() == null) {
            throw new CustomValidationException(
                    "Annual Rate",
                    "MISSING_FIELD",
                    "Interest amount is required"
            );
        }

        if(dto.getPrincipal().compareTo(BigDecimal.ZERO) <= 0) {
            throw new CustomValidationException(
                    "Principal",
                    "INVALID_DATA",
                    "Principal must be greater than 0"
            );
        }

        if(dto.getAnnualRate().compareTo(BigDecimal.ZERO) <= 0) {
            throw new CustomValidationException(
                    "Annual Rate",
                    "INVALID_DATA",
                    "Interest must be greater than 0"
            );
        }

        if(dto.getAnnualRate().compareTo(new BigDecimal(28)) > 0) {
            throw new CustomValidationException(
                    "Annual Rate",
                    "INVALID_DATA",
                    "Interest Rate cannot exceed 28%"
            );
        }

        if(dto.getMonths() <= 0) {
            throw new CustomValidationException(
                    "Months",
                    "INVALID_DATA",
                    "Loan duration must be at least 1 month"
            );
        }

        return true;
    }
}
