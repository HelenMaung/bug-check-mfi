package com.mo.service;

import java.util.List;

import com.mo.dto.request.LoanRequestDto;
import com.mo.dto.respond.LoanRespondDto;

public interface LoanService {
	
	LoanRespondDto createLoan(LoanRequestDto dto);
	
	LoanRespondDto getLoanById(Long id);
	
	List<LoanRespondDto> getAllLoans();
	
	void deleteLoan(Long id);
}
