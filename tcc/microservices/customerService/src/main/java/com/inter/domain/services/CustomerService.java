package com.inter.domain.services;

import com.inter.domain.model.Customer;
import com.inter.repo.CustomerRepository;
import io.micronaut.context.annotation.Prototype;

import javax.inject.Inject;

@Prototype
public class CustomerService {

    @Inject
    CustomerRepository repository;

    public Customer get(String cpf) {
        try {
            return repository.findByCpf(cpf);
        }
        catch (Exception e) {
            return null;
        }
    }

    public Customer save(String name, String cpf) {
        Customer newCustomer = new Customer();
        newCustomer.setName(name);
        newCustomer.setCpf(cpf);
        return repository.save(newCustomer);
    }
}
