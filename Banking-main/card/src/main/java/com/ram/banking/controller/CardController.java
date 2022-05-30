package com.ram.banking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ram.banking.entity.Card;
import com.ram.banking.model.APIResponse;
import com.ram.banking.service.CardService;

@RestController
public class CardController {
	
	@Autowired
	private CardService service;
	
	@GetMapping("/cards")
	public APIResponse getCards() {
		return service.getCards();
	}
	
	@PostMapping("/cards")
	public APIResponse createCard(@Valid @RequestBody Card card) {
		return service.createCard(card);
	}

}
