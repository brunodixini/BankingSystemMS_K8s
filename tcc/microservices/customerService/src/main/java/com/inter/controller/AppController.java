package com.inter.controller;


import com.inter.domain.model.Customer;
import com.inter.domain.services.CustomerService;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;

import static java.util.Objects.isNull;

@Controller("/customer")
public class AppController {

    @Inject
    CustomerService customerService;

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    public Object get(@Header String cpf) {
        Customer customer = customerService.get(cpf);
        if(isNull(customer)) {
            return HttpStatus.NO_CONTENT;
        } else {
            return customer;
        }
    }

    @Post
    @Produces(MediaType.APPLICATION_JSON)
    public Object post(@Header String name, @Header String cpf) {
        return customerService.save(name, cpf);
    }
}






