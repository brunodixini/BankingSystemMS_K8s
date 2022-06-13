package com.microdata.services;

import io.micronaut.context.annotation.Prototype;

import javax.inject.Inject;

@Prototype
public class AccountService {

    @Inject
    private CrudService repo;

    public Object get(String cpf) {
        return "OK";
    }

    public Object post(String name, String cpf) { return "OK"; }
}
