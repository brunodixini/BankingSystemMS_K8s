package com.inter.repo;

import com.inter.domain.model.Loan;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long> {

    Loan findByCpf(String cpf);
}
