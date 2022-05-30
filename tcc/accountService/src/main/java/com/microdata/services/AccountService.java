package com.microdata.services;

import io.micronaut.context.annotation.Prototype;

import javax.inject.Inject;

@Prototype
public class AccountService {

    @Inject
    private CrudService repo;

    public Object getUser(Integer id) {
        return "OK";
    }

    public Object saveUser(String name, String cpf) { return "OK"; }
}
