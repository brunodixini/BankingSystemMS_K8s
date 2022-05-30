package com.ram.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ram.banking.entity.Loan;

@Repository
public interface LoanRepositry extends JpaRepository<Loan, Integer> {

}
