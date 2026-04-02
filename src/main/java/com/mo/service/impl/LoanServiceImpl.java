package com.mo.service.impl;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mo.dto.request.LoanRequestDto;
import com.mo.dto.respond.LoanRespondDto;
import com.mo.entity.Loan;
import com.mo.entity.LoanProduct;
import com.mo.entity.Member;
import com.mo.mappers.LoanMapper;
import com.mo.repository.LoanProductRepo;
import com.mo.repository.LoanRepo;
import com.mo.repository.MemberRepo;
import com.mo.service.LoanService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService{
	
	private final LoanRepo loanRepo;
	private final MemberRepo memberRepo;
	private final LoanProductRepo productRepo;
	private final LoanMapper loanMapper;
	
	@Override
	public LoanRespondDto createLoan(LoanRequestDto dto) {
		
		LoanProduct product = productRepo.findById(dto.getLoanProductId())
				.orElseThrow(()-> new RuntimeException("Loan product not found"));
		
		Member member = memberRepo.findById(dto.getMemberId())
				.orElseThrow(()-> new RuntimeException("Member not found"));
		
		Loan loan = loanMapper.toEntity(dto);
		loan.setLoanProduct(product);
		loan.setMember(member);
		
		BigDecimal principal = dto.getPrincipal();
		BigDecimal rate = dto.getInterestRate();
		int months = dto.getMonths();
		
		BigDecimal totalInterest = principal.multiply(rate)
				.multiply(BigDecimal.valueOf(months))
				.divide(BigDecimal.valueOf(100));
		
		BigDecimal totalRepayment = principal.add(totalInterest);
		
        BigDecimal emi = totalRepayment.divide(BigDecimal.valueOf(months));
        
        loan.setTotalInterest(totalInterest);
        loan.setTotalRepayment(totalRepayment);
        loan.setEmiAmount(emi);
        Loan saveLoan = loanRepo.save(loan);
        
		return loanMapper.toDto(saveLoan);
	}
	@Override
	public LoanRespondDto getLoanById(Long id) {
		
		Loan loan = loanRepo.findById(id).orElseThrow(()->new RuntimeException("Loan not found!"));
		return loanMapper.toDto(loan);
	}
//	@Override
//	public List<LoanRespondDto> getAllLoans() {
//		
//		return loanRepo.findAll().stream().map(loanMapper::toDto).toList();
//	}
	
	@Override
	public void deleteLoan(Long id) {
		loanRepo.deleteById(id);
	}
	
	@Override
	public Page<LoanRespondDto> getAllLoans(int page, int size) {
		
		Pageable pagable = PageRequest.of(page, size);
		Page<Loan> entityPages = loanRepo.findAll(pagable);
		Page<LoanRespondDto> dtoPages = entityPages.map(entity -> loanMapper.toDto(entity));
		
		return dtoPages;
	}

	
	

}
