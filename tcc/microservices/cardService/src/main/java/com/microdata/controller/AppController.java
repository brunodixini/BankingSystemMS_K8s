package com.microdata.controller;


import com.microdata.services.AccountService;
import com.microdata.services.CardService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;

@Controller("/card")
public class AppController {

    @Inject
    CardService cardService;

    @Inject
    AccountService accountService;

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    public Object get(@Header String cardAccount) {
        return cardService.get(cardAccount);
    }

    @Post
    @Produces(MediaType.APPLICATION_JSON)
    public Object post(@Header String name, @Header String banckAccount, @Header String cardNumber) {
        String validationresponse = accountService.validateAccount(banckAccount);
        if(validationresponse.equals("OK")) {
            cardService.post(name, cardNumber);
            return "Conta corrente validada e cartão criado.";
        } else {
            return "Conta corrente nao encontrada.";
        }
    }
}






