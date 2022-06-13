package com.microdata.services;

import com.microdata.client.CustomerClient;
import io.micronaut.context.annotation.Prototype;

import javax.inject.Inject;
import java.util.Optional;

@Prototype
public class CustomerService {

    @Inject
    private CustomerClient client;

    public String validateCustomer(String cpf) {
        try {
            return client.getUSerInfo(cpf).blockingFirst();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
