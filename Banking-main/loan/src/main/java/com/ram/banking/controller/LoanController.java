package com.ram.banking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ram.banking.entity.Loan;
import com.ram.banking.model.APIResponse;
import com.ram.banking.service.LoanService;

@RestController
public class LoanController {
	
	@Autowired
	private LoanService service;
	
	@GetMapping("/loans")
	public APIResponse getLoans() {
		return service.getLoans();
	}
	
	@PostMapping("/loans")
	public APIResponse createLoan(@Valid @RequestBody Loan loan) {
		return service.createLoan(loan);
	}

}
