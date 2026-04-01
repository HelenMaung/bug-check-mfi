package com.mo.dto.request;

import java.math.BigDecimal;

import com.mo.enums.CalculationType;

import com.mo.validation.ValidateLoanProductType;
import lombok.Data;

@Data
@ValidateLoanProductType
public class LoanProductRequestDto {
	
	private BigDecimal principal;
	private BigDecimal annualRate;
	private int months;
	private CalculationType calculationType;

}
