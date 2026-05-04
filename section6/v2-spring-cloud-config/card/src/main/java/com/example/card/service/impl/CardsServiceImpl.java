package com.example.card.service.impl;

import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.card.constant.CardsConstants;
import com.example.card.dto.CardsDto;
import com.example.card.entity.Cards;
import com.example.card.exception.CardsAlreadyExistException;
import com.example.card.exception.ResourceNotFoundException;
import com.example.card.mapper.CardsMapper;
import com.example.card.repository.CardsRepository;
import com.example.card.service.ICardsService;


import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CardsServiceImpl implements ICardsService {


	private CardsRepository cardsRepository;

	@Override
	public void createCard(String mobileNumber) {
		// TODO Auto-generated method stub

		Optional<Cards> optionalCard = cardsRepository.findByMobileNumber(mobileNumber);
		if (optionalCard.isPresent()) {
			throw new CardsAlreadyExistException("Card already registered with given mobileNumber" + mobileNumber);
		}
		Cards newCard = createNewCard(mobileNumber);
		cardsRepository.save(newCard);

	}

	private Cards createNewCard(String mobileNumber) {
		Cards newCard = new Cards();
		long randomCardNumber = 100000000000L + new Random().nextInt(90000000);
		
		int totalCard = CardsConstants.NEW_CARD_LIMIT;
		
		newCard.setCardNumber(Long.toString(randomCardNumber));
		newCard.setMobileNumber(mobileNumber);
		newCard.setCardType(CardsConstants.CREDIT_CARD);
		
		newCard.setTotalLimit(totalCard);
		newCard.setAmountUsed(0);
		newCard.setAvailableAmount(totalCard);
		return newCard;

	}

	@Override
	public CardsDto fetchCard(String mobileNumber) {
		// TODO Auto-generated method stub

		Cards cards = cardsRepository.findByMobileNumber(mobileNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber));

		return CardsMapper.mapToCardsDto(cards, new CardsDto());
	}

	@Override
	public boolean updatedCard(CardsDto cardsDto) {
		// TODO Auto-generated method stub

		Cards cards = cardsRepository.findByCardNumber(cardsDto.getCardNumber())
				.orElseThrow(() -> new ResourceNotFoundException("Card", "Card Number", cardsDto.getCardNumber()));
		CardsMapper.mapToCards(cardsDto, cards);
		cardsRepository.save(cards);
		return true;
	}

	@Override
	public boolean deleteCard(String mobileNumber) {
		// TODO Auto-generated method stub

		Cards cards = cardsRepository.findByMobileNumber(mobileNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber));
		cardsRepository.deleteById(cards.getCardId());
		return true;
	}


}
