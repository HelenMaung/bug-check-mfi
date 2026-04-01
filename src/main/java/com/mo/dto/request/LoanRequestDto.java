package com.mo.dto.request;

import java.math.BigDecimal;

import com.mo.enums.CalculationType;
import com.mo.validation.ValidateLoan;

import lombok.Data;

@Data
@ValidateLoan
public class LoanRequestDto {

		private Integer months;
		private Long memberId;
		private Long loanProductId;
		private BigDecimal principal;
		private BigDecimal interestRate;
		private CalculationType calculationType;
		
}
