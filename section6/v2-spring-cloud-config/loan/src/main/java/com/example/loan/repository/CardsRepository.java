package com.example.loan.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.loan.entity.Loan;

@Repository
public interface CardsRepository extends JpaRepository<Loan, Long> {

	Optional<Loan> findByMobileNumber(String mobileNumber);

	Optional<Loan> findByLoanNumber(String loanNumber);
}
