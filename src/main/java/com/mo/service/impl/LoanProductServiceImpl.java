package com.mo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mo.dto.request.LoanProductRequestDto;
import com.mo.dto.respond.LoanProductRespondDto;
import com.mo.repository.LoanProductRepo;
import com.mo.service.LoanProductService;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor
public class LoanProductServiceImpl implements LoanProductService{

	private final LoanProductRepo productRepo;

	@Override
	public List<LoanProductRespondDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoanProductRespondDto createLoanProduct(LoanProductRequestDto productDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoanProductRespondDto updateLoanProduct(LoanProductRequestDto updateLoanProduct, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LoanProductRespondDto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
