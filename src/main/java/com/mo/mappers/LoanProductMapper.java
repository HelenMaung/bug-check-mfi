package com.mo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mo.dto.request.LoanProductRequestDto;
import com.mo.dto.respond.LoanProductRespondDto;
import com.mo.entity.LoanProduct;

@Mapper(componentModel = "spring")
public interface LoanProductMapper {

	@Mapping(target = "id", ignore = true)
    @Mapping(target = "loans", ignore = true)
    LoanProduct toEntity(LoanProductRequestDto request);

    LoanProductRespondDto toResponse(LoanProduct entity);

}
