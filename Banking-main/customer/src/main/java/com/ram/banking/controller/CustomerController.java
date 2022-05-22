package com.ram.banking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ram.banking.entity.Customer;
import com.ram.banking.model.APIResponse;
import com.ram.banking.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping("/customers")
	public APIResponse getCustomers() {
		return service.getCustomers();
	}
	
	@PostMapping("/customers")
	public APIResponse createCustomer(@Valid @RequestBody Customer customer) {
		return service.createCustomer(customer);
	}

}
