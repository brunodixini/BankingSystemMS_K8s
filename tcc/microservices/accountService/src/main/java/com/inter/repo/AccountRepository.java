package com.inter.repo;

import com.inter.domain.model.Account;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    Account findByCpf(String cpf);
}
