package com.example.card.service;

import com.example.card.dto.CardsDto;

public interface ICardsService {

	/*
	 * @param mobileNumber - Mobile Number of the Customer
	 * 
	 */
	void createCard(String mobileNumber);

	/*
	 * @param mobileNumber - Input mobile Number
	 * 
	 * @return Loan Details based on a given mobileNumber
	 */
	CardsDto fetchCard(String mobileNumber);

	/*
	 * @param loansDto - LoansDto Object
	 * 
	 * @return boolean indicating if the update of card details is successful or not
	 */
	boolean updatedCard(CardsDto cardsDto);

	/*
	 * @param mobileNumber - Input Mobile Number
	 * 
	 * @return boolean indicating if the delete of loan details is successful or not
	 */
	boolean deleteCard(String mobileNumber);
}
