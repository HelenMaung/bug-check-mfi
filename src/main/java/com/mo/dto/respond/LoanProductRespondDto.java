package com.mo.dto.respond;

import java.math.BigDecimal;

import com.mo.enums.CalculationType;

import lombok.Data;

@Data
public class LoanProductRespondDto {
	
	private Long id;
	private BigDecimal principal;
	private BigDecimal annualRate;
	private int months;
	private CalculationType calculationType;


}
