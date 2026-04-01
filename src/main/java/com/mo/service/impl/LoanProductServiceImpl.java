package com.mo.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mo.dto.request.LoanProductRequestDto;
import com.mo.dto.respond.LoanProductRespondDto;
import com.mo.entity.LoanProduct;
import com.mo.mappers.LoanProductMapper;
import com.mo.repository.LoanProductRepo;
import com.mo.service.LoanProductService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoanProductServiceImpl implements LoanProductService {

	private final LoanProductRepo productRepo;
	private final LoanProductMapper productMapper;

	@Override
	public List<LoanProductRespondDto> findAll() {
		return productRepo.findAll().stream().map(productMapper::toDto).toList();
	}

	@Override
	public LoanProductRespondDto createLoanProduct(LoanProductRequestDto productDto) {
		LoanProduct entity = productMapper.toEntity(productDto);
        return productMapper.toDto(productRepo.save(entity));		
	}

	@Override
	public LoanProductRespondDto updateLoanProduct(LoanProductRequestDto updateProduct, Long id) {
		 LoanProduct existing = productRepo.findById(id)
	                .orElseThrow(() -> new EntityNotFoundException("LoanProduct not found"));

	        productMapper.updateEntityFromDto(updateProduct, existing);

	        return productMapper.toDto(productRepo.save(existing));
	}

	@Override
	public void deleteProduct(Long id) {

		LoanProduct entity = productRepo.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("LoanProduct not found"));

		productRepo.delete(entity);
	}

	@Override
	public LoanProductRespondDto findById(Long id) {
		
		LoanProduct entity = productRepo.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("LoanProduct not found"));

		return productMapper.toDto(entity);
	}

	@Override
	public Page<LoanProductRespondDto> getAllProducts(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<LoanProduct> entityPages = productRepo.findAll(pageable);
		Page<LoanProductRespondDto> dtoPages = entityPages.map(entity -> productMapper.toDto(entity));
		return dtoPages;
	}

}
