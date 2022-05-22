package com.ram.banking.service;

import com.ram.banking.entity.Card;
import com.ram.banking.model.APIResponse;

public interface CardService {

	APIResponse getCards();

	APIResponse createCard(Card card);

}
