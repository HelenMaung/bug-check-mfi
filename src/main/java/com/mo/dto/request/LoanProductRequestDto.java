package com.mo.dto.request;

import java.math.BigDecimal;

import com.mo.enums.CalculationType;

import lombok.Data;

@Data
public class LoanProductRequestDto {
	
	private BigDecimal principal;
	private BigDecimal annualRate;
	private int months;
	private CalculationType calculationType;

}
