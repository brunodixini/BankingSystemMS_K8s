package com.inter.services;

import io.micronaut.context.annotation.Prototype;

import javax.inject.Inject;

@Prototype
public class ContaCorrenteService {

    @Inject
    CrudService transactionService;

    public Object getLoans(String cpf) {
        return "OK";
    }

    public Object saveLoan(String name, String cpf) {
        return "OK";
    }
}
