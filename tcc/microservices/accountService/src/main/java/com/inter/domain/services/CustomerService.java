package com.inter.domain.services;

import com.inter.client.CustomerClient;
import io.micronaut.context.annotation.Prototype;

import javax.inject.Inject;

@Prototype
public class CustomerService {

    @Inject
    private CustomerClient client;

    public String validateCustomer(String cpf) {
        try {
            return client.getUSerInfo(cpf).blockingFirst();
        } catch (Exception e) {
            return null;
        }
    }
}
