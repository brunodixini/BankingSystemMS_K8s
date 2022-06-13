package com.microdata.controller;


import com.microdata.services.AccountService;
import com.microdata.services.CustomerService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;
import java.util.Optional;

@Controller("/account")
public class AppController {

    @Inject
    AccountService accountService;

    @Inject
    CustomerService customerService;

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    public Object get(@Header String cpf) {
        return accountService.get(cpf);
    }

    @Post
    @Produces(MediaType.APPLICATION_JSON)
    public Object post(@Header String name, @Header String cpf) {
        String validationresponse = customerService.validateCustomer(cpf);
        if(validationresponse.equals("OK")) {
            accountService.post(name, cpf);
            return "Cliente validado e conta criada.";
        } else {
            return "Cliente nao encontrado.";
        }
    }
}






