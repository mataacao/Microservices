package com.example.loan.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.loan.entity.Cards;

@Repository
public interface CardsRepository extends JpaRepository<Cards, Long> {

	Optional<Cards> findByMobileNumber(String mobileNumber);

	Optional<Cards> findByLoanNumber(String loanNumber);
}
