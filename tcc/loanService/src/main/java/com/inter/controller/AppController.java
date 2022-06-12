package com.inter.controller;


import com.inter.services.ContaCorrenteService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;

@Controller("/loan")
public class AppController {

    @Inject
    ContaCorrenteService contaCorrenteService;

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    public Object get(@Header String cpf) {
        return contaCorrenteService.get(cpf);
    }

    @Post
    @Produces(MediaType.APPLICATION_JSON)
    public Object post(@Header String cpf, @Header String name, @Header String amount) {
        // bater no servico de conta para validar conta do cliente e ver se pode fazer emprestimo
        return contaCorrenteService.save(name, cpf, amount);
    }
}






