package com.microdata.controller;


import com.microdata.services.CardService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;

@Controller("/cardAccount")
public class AppController {

    @Inject
    CardService cardService;

    @Get("/card")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getCard(@Header int id) {
        return cardService.getCard(id);
    }

    @Post("/card")
    @Produces(MediaType.APPLICATION_JSON)
    public Object postCard(@Header String name, @Header String cardNumber) {
        // bater no userService pra validar usuario e ver se pode criar cartao
        return cardService.postCard(cardNumber);
    }
}






