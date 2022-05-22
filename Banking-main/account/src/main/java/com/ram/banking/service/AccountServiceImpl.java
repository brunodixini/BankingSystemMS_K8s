package com.ram.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ram.banking.entity.Account;
import com.ram.banking.model.APIResponse;
import com.ram.banking.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepository repository;

	@Override
	public APIResponse getAccount() {
		return APIResponse.builder().status(HttpStatus.OK).data(repository.findAll()).build();
	}

	@Override
	public APIResponse createAccount(Account account) {
		return APIResponse.builder().status(HttpStatus.OK).data(repository.save(account)).build();
	}

}
