package com.mo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mo.dto.request.LoanProductRequestDto;
import com.mo.dto.respond.LoanProductRespondDto;
import com.mo.service.impl.LoanProductServiceImpl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class LoanProductController {

	private final LoanProductServiceImpl productService;

	@GetMapping
	public List<LoanProductRespondDto> getAll() {
		return productService.findAll();
	}

	@GetMapping("/{id}")
	public LoanProductRespondDto getById(@PathVariable Long id) {
		return productService.findById(id);
	}

	@PostMapping
	public LoanProductRespondDto createLoanProduct(@Valid @RequestBody LoanProductRequestDto product) {

		return productService.createLoanProduct(product);
	}

	@PutMapping("/{id}")
	public LoanProductRespondDto updateData(@Valid @RequestBody LoanProductRequestDto product, Long id) {

		return productService.updateLoanProduct(product, id);
	}

	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}

}
