package com.microdata.controller;


import com.microdata.services.CardService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;

@Controller("/card")
public class AppController {

    @Inject
    CardService cardService;

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    public Object get(@Header String cardAccount) {
        return cardService.getCard(cardAccount);
    }

    @Post
    @Produces(MediaType.APPLICATION_JSON)
    public Object post(@Header String name, @Header String cardNumber) {
        // bater no userService pra validar usuario e ver se pode criar cartao
        return cardService.postCard(cardNumber);
    }
}






