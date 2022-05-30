package com.inter.controller;


import com.inter.services.CustomerService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;

@Controller("/customerInformation")
public class AppController {

    @Inject
    CustomerService customerService;

    @Get("/customer")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getCustomer(@Header String cpf) {
        return customerService.getCustomer(cpf);
    }

    @Post("/customer")
    @Produces(MediaType.APPLICATION_JSON)
    public Object postCustomer(@Header String name, @Header String cpf) {
        return customerService.saveCustomer(name, cpf);
    }
}






