package com.mo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mo.dto.request.LoanRequestDto;
import com.mo.dto.respond.LoanRespondDto;
import com.mo.service.impl.LoanServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/loan")
public class LoanController {
	
	private final LoanServiceImpl loanService;
	
	@PostMapping
	public LoanRespondDto createLoan(@RequestBody LoanRequestDto dto) {
		return loanService.createLoan(dto);
	}
	
	@GetMapping("/{id}")
	public LoanRespondDto getLoan(@PathVariable Long id) {
			return loanService.getLoanById(id);
	}
	
	@GetMapping
	public List<LoanRespondDto> getAllLoans(){
		return loanService.getAllLoans();
		
	}
	
	@DeleteMapping
	public void deleteLoan(@PathVariable Long id) {
		
		loanService.deleteLoan(id);
		
	}
	
}
