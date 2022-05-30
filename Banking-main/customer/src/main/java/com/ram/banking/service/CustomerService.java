package com.ram.banking.service;

import com.ram.banking.entity.Customer;
import com.ram.banking.model.APIResponse;

public interface CustomerService {

	APIResponse getCustomers();

	APIResponse createCustomer(Customer customer);

}
