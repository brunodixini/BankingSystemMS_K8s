package com.ram.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ram.banking.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

}
