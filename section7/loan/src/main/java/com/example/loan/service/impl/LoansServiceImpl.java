package com.example.loan.service.impl;

import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.loan.constant.LoansConstants;
import com.example.loan.dto.LoansDto;
import com.example.loan.entity.Loans;
import com.example.loan.exception.LoansAlreadyExistException;
import com.example.loan.exception.ResourceNotFoundException;
import com.example.loan.mapper.LoansMapper;
import com.example.loan.repository.LoansRepository;
import com.example.loan.service.ILoansService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoansServiceImpl implements ILoansService {

	private LoansRepository loansRepository;

	@Override
	public void createLoan(String mobileNumber) {
		// TODO Auto-generated method stub

		Optional<Loans> optionalLoans = loansRepository.findByMobileNumber(mobileNumber);
		if (optionalLoans.isPresent()) {
			throw new LoansAlreadyExistException("Loans already registered with given mobileNumber" + mobileNumber);
		}
		Loans newLoan = createNewLoan(mobileNumber);
		loansRepository.save(newLoan);

	}

	private Loans createNewLoan(String mobileNumber) {
		Loans newLoan = new Loans();
		long randomLoanNumber = 100000000000L + new Random().nextInt(90000000);
		
		int totalLoan = LoansConstants.NEW_LOAN_LIMIT;
		
		newLoan.setLoanNumber(Long.toString(randomLoanNumber));
		newLoan.setMobileNumber(mobileNumber);
		newLoan.setLoanType(LoansConstants.HOME_LOAN);
		
		newLoan.setTotalLoan(totalLoan);
		newLoan.setAmountPaid(0);
		newLoan.setOutstandingAmount(totalLoan);
		return newLoan;

	}

	@Override
	public LoansDto fetchLoan(String mobileNumber) {
		// TODO Auto-generated method stub

		Loans loans = loansRepository.findByMobileNumber(mobileNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber));

		return LoansMapper.mapToLoansDto(loans, new LoansDto());
	}

	@Override
	public boolean updatedLoan(LoansDto loansDto) {
		// TODO Auto-generated method stub

		Loans loans = loansRepository.findByLoanNumber(loansDto.getLoanNumber())
				.orElseThrow(() -> new ResourceNotFoundException("Loan", "Loan Number", loansDto.getLoanNumber()));
		LoansMapper.mapToLoans(loansDto, loans);
		loansRepository.save(loans);
		return true;
	}

	@Override
	public boolean deleteLoan(String mobileNumber) {
		// TODO Auto-generated method stub

		Loans loans = loansRepository.findByMobileNumber(mobileNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber));
		loansRepository.deleteById(loans.getLoanId());
		return true;
	}

}
