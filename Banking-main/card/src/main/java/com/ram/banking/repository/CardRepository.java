package com.ram.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ram.banking.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer>{

}
