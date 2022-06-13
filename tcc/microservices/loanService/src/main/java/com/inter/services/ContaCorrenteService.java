package com.inter.services;

import io.micronaut.context.annotation.Prototype;

import javax.inject.Inject;

@Prototype
public class ContaCorrenteService {

    @Inject
    CrudService transactionService;

    public Object get(String cpf) {
        return "OK";
    }

    public Object save(String name, String cpf, String amount) {
        return "OK";
    }
}
