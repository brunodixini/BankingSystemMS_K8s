package com.inter.domain.services;

import com.inter.domain.model.Card;
import com.inter.repo.CardRepository;
import io.micronaut.context.annotation.Prototype;

import javax.inject.Inject;

@Prototype
public class CardService {

    @Inject
    private CardRepository repository;

    public Card get(String cpf) {
        try {
            return repository.findByCpf(cpf);
        }
        catch (Exception e) {
            return null;
        }
    }

    public Card post(String cpf, String cardNumber) {
        Card newCard = new Card();
        newCard.setCpf(cpf);
        newCard.setCard(cardNumber);
        return repository.save(newCard);
    }

}
