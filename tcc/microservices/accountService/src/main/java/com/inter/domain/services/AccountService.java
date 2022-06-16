package com.inter.domain.services;

import com.inter.domain.model.Account;
import com.inter.repo.AccountRepository;
import io.micronaut.context.annotation.Prototype;

import javax.inject.Inject;

@Prototype
public class AccountService {

    @Inject
    private AccountRepository repository;

    public Account get(String cpf) {
        try {
            return repository.findByCpf(cpf);
        }
        catch (Exception e) {
            return null;
        }
    }

    public Object post(String cpf, String accountNumber) {
        Account newAccount = new Account();
        newAccount.setCpf(cpf);
        newAccount.setAccount(accountNumber);
        return repository.save(newAccount);
    }
}
