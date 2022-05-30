package com.inter.controller;


import com.inter.services.ContaCorrenteService;
import com.inter.services.CrudService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;
import java.util.Random;

@Controller("/loan")
public class AppController {

    @Inject
    ContaCorrenteService contaCorrenteService;

    @Get("/find")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getLoan(@Header String cpf) {
        return contaCorrenteService.getLoans(cpf);
    }

    @Post("/new")
    @Produces(MediaType.APPLICATION_JSON)
    public Object postLoan(@Header String cpf, @Header String name) {
        // bater no servico de conta para validar conta do cliente e ver se pode fazer emprestimo
        return contaCorrenteService.saveLoan(name, cpf);
    }
}






