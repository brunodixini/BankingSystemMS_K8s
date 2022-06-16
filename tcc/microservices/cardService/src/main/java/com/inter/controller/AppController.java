package com.inter.controller;


import com.inter.domain.model.Card;
import com.inter.domain.services.AccountService;
import com.inter.domain.services.CardService;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;

import static java.util.Objects.isNull;

@Controller("/card")
public class AppController {

    @Inject
    CardService cardService;

    @Inject
    AccountService accountService;

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    public Object get(@Header String cpf) {
        Card card = cardService.get(cpf);
        if(isNull(card)) {
            return HttpStatus.NO_CONTENT;
        } else {
            return card;
        }
    }

    @Post
    @Produces(MediaType.APPLICATION_JSON)
    public Object post(@Header String cpf, @Header String cardNumber) {
        String validationresponse = accountService.validateAccount(cpf);
        if(isNull(validationresponse)) {
            return "O cliente ainda não possui conta corrente, não foi possível criar um cartão.";
        } else {
            return cardService.post(cpf, cardNumber);
        }
    }
}






