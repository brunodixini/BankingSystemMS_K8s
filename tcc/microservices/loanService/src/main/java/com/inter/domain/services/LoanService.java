package com.inter.domain.services;

import com.inter.domain.model.Loan;
import com.inter.repo.LoanRepository;
import io.micronaut.context.annotation.Prototype;

import javax.inject.Inject;

@Prototype
public class LoanService {

    @Inject
    private LoanRepository repository;

    public Loan get(String cpf) {
        try {
            return repository.findByCpf(cpf);
        }
        catch (Exception e) {
            return null;
        }
    }

    public Loan post(String cpf, String amount) {
        Loan newLoan = new Loan();
        newLoan.setCpf(cpf);
        newLoan.setAmount(amount);
        return repository.save(newLoan);
    }

}
