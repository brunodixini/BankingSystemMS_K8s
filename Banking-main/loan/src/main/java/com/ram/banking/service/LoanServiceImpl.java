package com.ram.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ram.banking.entity.Loan;
import com.ram.banking.model.APIResponse;
import com.ram.banking.repository.LoanRepositry;

@Service
public class LoanServiceImpl implements LoanService {
	
	@Autowired
	private LoanRepositry repositry;

	@Override
	public APIResponse getLoans() {
		return APIResponse.builder().status(HttpStatus.OK).data(repositry.findAll()).build();
	}

	@Override
	public APIResponse createLoan(Loan loan) {
		return APIResponse.builder().status(HttpStatus.OK).data(repositry.save(loan)).build();
	}

}
