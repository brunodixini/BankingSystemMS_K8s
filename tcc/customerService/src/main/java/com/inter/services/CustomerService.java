package com.inter.services;

import io.micronaut.context.annotation.Prototype;

import javax.inject.Inject;

@Prototype
public class CustomerService {

    @Inject
    CrudService transactionService;

    public Object getCustomer(String cpf) {
        return "OK";
    }

    public Object saveCustomer(String name, String cpf) { return "OK"; }
}