package com.inter.controller;


import com.inter.services.AccountService;
import com.inter.services.ContaCorrenteService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;

@Controller("/loan")
public class AppController {

    @Inject
    ContaCorrenteService contaCorrenteService;

    @Inject
    AccountService accountService;

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    public Object get(@Header String cpf) {
        return contaCorrenteService.get(cpf);
    }

    @Post
    @Produces(MediaType.APPLICATION_JSON)
    public Object post(@Header String name, @Header String banckAccount, @Header String amount) {
        String validationresponse = accountService.validateAccount(banckAccount);
        if(validationresponse.equals("OK")) {
            contaCorrenteService.save(name, "CPF vasi vir na response", amount);
            return "Conta corrente validada e empréstimo concedido.";
        } else {
            return "Conta corrente nao encontrada.";
        }
    }
}






