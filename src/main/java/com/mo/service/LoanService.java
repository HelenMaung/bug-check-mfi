package com.mo.service;

import org.springframework.data.domain.Page;

import com.mo.dto.request.LoanRequestDto;
import com.mo.dto.respond.LoanRespondDto;

public interface LoanService {
	
	LoanRespondDto createLoan(LoanRequestDto dto);
	
	LoanRespondDto getLoanById(Long id);
	
//	List<LoanRespondDto> getAllLoans();
	
	void deleteLoan(Long id);
	
	Page<LoanRespondDto> getAllLoans(int page, int size);
	
	
}
