package com.ram.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ram.banking.entity.Customer;
import com.ram.banking.model.APIResponse;
import com.ram.banking.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	

	@Override
	public APIResponse getCustomers() {
		return APIResponse.builder().status(HttpStatus.OK).data(repository.findAll()).build();
	}


	@Override
	public APIResponse createCustomer(Customer customer) {
		return APIResponse.builder().status(HttpStatus.OK).data(repository.save(customer)).build();
	}

}
