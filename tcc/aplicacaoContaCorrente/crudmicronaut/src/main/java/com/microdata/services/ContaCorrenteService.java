package com.microdata.services;

import io.micronaut.context.annotation.Prototype;

@Prototype
public class ContaCorrenteService {

    public Object getSaldo(Integer id) {
        return "OK";
    }
}
