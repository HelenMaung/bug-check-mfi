package com.mo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.mo.dto.request.LoanRequestDto;
import com.mo.dto.respond.LoanRespondDto;
import com.mo.entity.Loan;

@Mapper(componentModel = "spring")
public interface LoanMapper {

	LoanMapper INSTANCE = Mappers.getMapper(LoanMapper.class);

	@Mapping(target = "member.id", source = "memberId")
	@Mapping(target = "loanProduct.id", source = "loanProductId")
	@Mapping(target = "totalInterest", ignore = true)
	@Mapping(target = "totalRepayment", ignore = true)
	@Mapping(target = "emiAmount", ignore = true)
	@Mapping(target = "id", ignore = true)
	Loan toEntity(LoanRequestDto dto);

	@Mapping(target = "memberId", source = "member.id")
	@Mapping(target = "loanProductId", source = "loanProduct.id")
	LoanRespondDto toDto(Loan loan);

}
