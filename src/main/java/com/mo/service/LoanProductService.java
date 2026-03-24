package com.mo.service;

import java.util.List;

import com.mo.dto.request.LoanProductRequestDto;
import com.mo.dto.respond.LoanProductRespondDto;

public interface LoanProductService {
	
	List<LoanProductRespondDto> findAll();
	
	LoanProductRespondDto createLoanProduct(LoanProductRequestDto productDto);
	
	LoanProductRespondDto updateLoanProduct(LoanProductRequestDto updateLoanProduct, Long id );
	
	void deleteProduct(Long id);
	
	LoanProductRespondDto findById(Long id);
}
