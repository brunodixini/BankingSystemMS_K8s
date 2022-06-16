package com.inter.repo;

import com.inter.domain.model.Customer;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	Customer findByCpf(String cpf);
}
