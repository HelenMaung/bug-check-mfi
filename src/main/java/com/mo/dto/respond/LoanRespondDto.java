package com.mo.dto.respond;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class LoanRespondDto {
	
	private Long id;
	private Long memberId;
	private Long loanProductId;
	private BigDecimal principal;
	private BigDecimal interestRate;
	private Integer months;
	private BigDecimal totalInterest;
	private BigDecimal totalRepayment;
	private BigDecimal emiAmount;

}
