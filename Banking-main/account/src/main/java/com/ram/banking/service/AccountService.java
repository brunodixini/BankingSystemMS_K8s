package com.ram.banking.service;

import com.ram.banking.entity.Account;
import com.ram.banking.model.APIResponse;

public interface AccountService {

	APIResponse getAccount();

	APIResponse createAccount(Account account);

}
