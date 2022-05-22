package com.microdata.controller;


import com.microdata.services.ContaCorrenteService;
import com.microdata.services.CrudService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;
import java.util.Random;

@Controller("/cashback")
public class AppController {

    @Inject
    CrudService transactionService;
    @Inject
    ContaCorrenteService contaCorrenteService;

    @Get("/totalpago")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getSaldo(@Header int id) {
        try {
            Random r = new Random();
            Integer delay = r.nextInt(500);
            Thread.sleep(delay);
            return contaCorrenteService.getSaldo(id);
        } catch (Exception exception) {
            return null;
        }
    }

    @Post("/pagamento")
    @Produces(MediaType.APPLICATION_JSON)
    public Object postTransaction(@Header int idTransaction) {
        try {
            Random r = new Random();
            Integer delay = r. nextInt(500);
            Thread.sleep(delay+1000);
            return transactionService.saveTransaction(idTransaction);
        } catch (Exception exception) {
            return null;
        }
    }
}






