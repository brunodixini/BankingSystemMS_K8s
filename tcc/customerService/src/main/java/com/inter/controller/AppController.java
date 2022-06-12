package com.inter.controller;


import com.inter.services.CustomerService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;

@Controller("/customer")
public class AppController {

    @Inject
    CustomerService customerService;

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    public Object get(@Header String cpf) {
        return customerService.get(cpf);
    }

    @Post
    @Produces(MediaType.APPLICATION_JSON)
    public Object post(@Header String name, @Header String cpf) {
        return customerService.save(name, cpf);
    }
}






