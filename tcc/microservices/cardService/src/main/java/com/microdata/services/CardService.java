package com.microdata.services;

import io.micronaut.context.annotation.Prototype;

import javax.inject.Inject;

@Prototype
public class CardService {

    @Inject
    CrudService repo;

    public Object get(String cardAccount) {
        return "OK";
    }

    public Object post(String name, String cardNumber) {  return "OK"; }

}
