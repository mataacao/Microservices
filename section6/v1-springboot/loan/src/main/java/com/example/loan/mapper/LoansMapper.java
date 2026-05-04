package com.example.loan.mapper;

import com.example.loan.dto.LoansDto;
import com.example.loan.entity.Loan;

public class LoansMapper {

	public static LoansDto mapToLoansDto(Loan loans, LoansDto loansDto) {
		loansDto.setLoanNumber(loans.getLoanNumber());
		loansDto.setMobileNumber(loans.getMobileNumber());
		loansDto.setLoanType(loans.getLoanType());
		loansDto.setTotalLoan(loans.getTotalLoan());
		loansDto.setAmountPaid(loans.getAmountPaid());
		loansDto.setOutstandingAmount(loans.getOutstandingAmount());
		return loansDto;
	}

	public static Loan mapToLoans(LoansDto loansDto, Loan loans) {
		loans.setLoanNumber(loansDto.getLoanNumber());
		loans.setMobileNumber(loansDto.getMobileNumber());
		loans.setLoanType(loansDto.getLoanType());
		loans.setTotalLoan(loansDto.getTotalLoan());
		loans.setAmountPaid(loansDto.getAmountPaid());
		loans.setOutstandingAmount(loansDto.getOutstandingAmount());
		return loans;
	}
}
