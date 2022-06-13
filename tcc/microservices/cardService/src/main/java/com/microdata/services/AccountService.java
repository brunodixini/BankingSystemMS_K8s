package com.microdata.services;

import com.microdata.client.AccountClient;
import io.micronaut.context.annotation.Prototype;

import javax.inject.Inject;

@Prototype
public class AccountService {

    @Inject
    private AccountClient client;

    public String validateAccount(String cpf) {
        try {
            return client.get(cpf).blockingFirst();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
