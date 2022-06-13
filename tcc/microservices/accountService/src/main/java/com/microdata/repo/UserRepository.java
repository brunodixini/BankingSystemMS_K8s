package com.microdata.repo;
import java.util.List;

import com.microdata.dto.Transaction;

import io.micronaut.context.annotation.Executable;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface UserRepository extends CrudRepository<Transaction, Long> {

	//@Executable
   // User find(String title);

	@Executable
	List<Transaction> findAll();
}
