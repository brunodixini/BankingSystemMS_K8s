package com.ram.banking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ram.banking.entity.Account;
import com.ram.banking.model.APIResponse;
import com.ram.banking.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService service;

	@GetMapping("/accounts")
	public APIResponse getAccounts() {
		return service.getAccount();
	}

	@PostMapping("/accounts")
	public APIResponse createAccount(@Valid @RequestBody Account account) {
		return service.createAccount(account);
	}

}
