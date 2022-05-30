package com.ram.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ram.banking.entity.Card;
import com.ram.banking.model.APIResponse;
import com.ram.banking.repository.CardRepository;

@Service
public class CardServiceImpl implements CardService {
	
	@Autowired
	private CardRepository repository;

	@Override
	public APIResponse getCards() {
		return APIResponse.builder().status(HttpStatus.OK).data(repository.findAll()).build();
	}

	@Override
	public APIResponse createCard(Card card) {
		return APIResponse.builder().status(HttpStatus.OK).data(repository.save(card)).build();
	}

}
