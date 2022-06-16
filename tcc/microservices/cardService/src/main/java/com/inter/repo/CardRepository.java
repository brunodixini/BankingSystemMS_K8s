package com.inter.repo;

import com.inter.domain.model.Card;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {

	Card findByCpf(String cpf);
}