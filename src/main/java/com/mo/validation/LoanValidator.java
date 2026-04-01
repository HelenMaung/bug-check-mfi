package com.mo.validation;

import java.math.BigDecimal;

import com.mo.dto.request.LoanRequestDto;
import com.mo.exception.CustomValidationException;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LoanValidator implements ConstraintValidator<ValidateLoan, LoanRequestDto> {

		
		@Override
	    public boolean isValid(LoanRequestDto dto, ConstraintValidatorContext context) {

	        if (dto == null) {
	            throw new CustomValidationException("Loan", "MISSING_OBJECT", "Loan Request is empty!");
	        }

	        if (dto.getMemberId() == null) {
	            throw new CustomValidationException("Member ID", "MISSING_FIELD", "Member ID is required!");
	        }

	        if (dto.getLoanProductId() == null) {
	            throw new CustomValidationException("Product ID", "MISSING_FIELD", "Loan Product ID is required!");
	        }

	        if (dto.getCalculationType() == null) {
	            throw new CustomValidationException("Calculation Type", "MISSING_FIELD", "Calculation type is required!");
	        }

	        if (dto.getPrincipal() == null) {
	            throw new CustomValidationException("Principal", "MISSING_FIELD", "Principal amount is required!");
	        } else if (dto.getPrincipal().compareTo(BigDecimal.ZERO) <= 0) {
	            throw new CustomValidationException("Principal", "INVALID_VALUE", "Principal must be greater than zero!");
	        }

	        if (dto.getInterestRate() == null) {
	            throw new CustomValidationException("Interest Rate", "MISSING_FIELD", "Interest rate is required!");
	        } else if (dto.getInterestRate().compareTo(BigDecimal.ZERO) < 0) {
	            throw new CustomValidationException("Interest Rate", "INVALID_VALUE", "Interest rate cannot be negative!");
	        }

	        if (dto.getMonths() == null) {
	            throw new CustomValidationException("Months", "MISSING_FIELD", "Loan duration (months) is required!");
	        } else if (dto.getMonths() <= 0) {
	            throw new CustomValidationException("Months", "INVALID_VALUE", "Months must be at least 1!");
	        }

	        return true;
	    	}

}
