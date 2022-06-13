package com.microdata.controller;


import com.microdata.services.AccountService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;

@Controller("/account")
public class AppController {

    @Inject
    AccountService accountService;

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    public Object getUser(@Header String cpf) {
        return accountService.get(cpf);
    }

    @Post
    @Produces(MediaType.APPLICATION_JSON)
    public Object postUser(@Header String name, @Header String cpf) {
        return accountService.post(name, cpf);
    }
}






