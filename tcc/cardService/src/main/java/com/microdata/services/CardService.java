package com.microdata.services;

import io.micronaut.context.annotation.Prototype;

import javax.inject.Inject;

@Prototype
public class CardService {

    @Inject
    CrudService repo;

    public Object getCard(String cardAccount) {
        return "OK";
    }

    public Object postCard(String cardNumber) {  return "OK"; }

}
