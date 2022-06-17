package com.inter.controller;


import com.inter.domain.model.Account;
import com.inter.domain.services.AccountService;
import com.inter.domain.services.CustomerService;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;

import static java.util.Objects.isNull;

@Controller("/account")
public class AppController {

    @Inject
    AccountService accountService;

    @Inject
    CustomerService customerService;

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    public Object get(@Header String cpf) {
        Account account = accountService.get(cpf);
        if(isNull(account)) {
            return HttpStatus.NO_CONTENT;
        } else {
            return account;
        }
    }

    @Post
    @Produces(MediaType.APPLICATION_JSON)
    public Object post(@Header String cpf, @Header String accountNumber) {
        String validationresponse = customerService.validateCustomer(cpf);
        if(isNull(validationresponse)) {
            return "Cliente não encontrado, não foi possível abrir a conta.";
        } else {
            return accountService.post(cpf, accountNumber);
        }
    }
}






