//package com.example.card.service.impl;
//
//import java.util.Random;
//
//import org.springframework.stereotype.Service;
//
//import com.example.card.constant.CardsConstants;
//import com.example.card.entity.Cards;
//import com.example.card.service.ICardsService;
//
//import lombok.AllArgsConstructor;
//
//@Service
//@AllArgsConstructor
//public class CardsServiceImpl implements ICardsService {
//
//	private ICardsService iCardsService;
//
//	@Override
//	public void createCard(String mobileNumber) {
//		// TODO Auto-generated method stub
//
//	}
//
//	private Cards createNewCard(String mobileNumber) {
//		Cards newCard = new Cards();
//		long randomCardNumber = 1000000000L + new Random().nextInt(90000000);
//		newCard.setCardNumber(Long.toString(randomCardNumber));
//		newCard.setMobileNumber(mobileNumber);
//		newCard.setCardType(CardsConstants.CREDIT_CARD);
//		newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
//		newCard.setAmountUsed(0);
//		newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
//		return newCard;
//	}
//
//}
