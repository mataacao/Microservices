package com.example.loan.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Schema(name = "Loan", description = "Schema to hold loan information")
public class LoansDto {

	@Schema(description = "Mobile Number of the customer", example = "4365327698")
	@NotEmpty(message = "Mobile Number can not be null or empty")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
	private String mobileNumber;

	@Schema(description = "Loan Number of the customer", example = "548732457654")
	@NotEmpty(message = "Loan Number can not be null or empty")
	@Pattern(regexp = "(^$|[0-9]{12})", message = "LoanNumber must be 12 digits")
	private String loanNumber;

	@Schema(description = "Type of the Loan ", example = "Home Loan")
	@NotEmpty(message = "Loan Type can not be null or empty")
	private String loanType;

	@Schema(description = "Total loan amount", example = "100000")
	@Positive(message = "Total loan amount should be greater than 0")
	private int totalLoan;

	@Schema(description = "Total loan amount paid", example = "1000")
	@Positive(message = "Total loan amount should be greater than 0")
	private int amountPaid;

	@Schema(description = "Total outstanding amount against loan", example = "1000")
	@Positive(message = "Total loan amount should be greater than 0")
	private int outstandingAmount;
}
