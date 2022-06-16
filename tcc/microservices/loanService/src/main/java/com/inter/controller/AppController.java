package com.inter.controller;


import com.inter.domain.model.Loan;
import com.inter.domain.services.AccountService;
import com.inter.domain.services.LoanService;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;

import static java.util.Objects.isNull;

@Controller("/loan")
public class AppController {

    @Inject
    LoanService loanService;

    @Inject
    AccountService accountService;

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    public Object get(@Header String cpf) {
        Loan loan = loanService.get(cpf);
        if(isNull(loan)) {
            return HttpStatus.NO_CONTENT;
        } else {
            return loan;
        }
    }

    @Post
    @Produces(MediaType.APPLICATION_JSON)
    public Object post(@Header String cpf, @Header String amount) {
        String validationresponse = accountService.validateAccount(cpf);
        if(isNull(validationresponse)) {
            return "O cliente ainda não possui conta corrente, não foi possível conceder o empréstimo";
        } else {
            return loanService.post(cpf, amount);
        }
    }
}






