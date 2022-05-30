package com.ram.banking.service;

import com.ram.banking.entity.Loan;
import com.ram.banking.model.APIResponse;

public interface LoanService {

	APIResponse getLoans();

	APIResponse createLoan(Loan loan);

}
