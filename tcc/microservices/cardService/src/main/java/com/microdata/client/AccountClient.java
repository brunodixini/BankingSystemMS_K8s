package com.microdata.client;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Flowable;

import javax.inject.Inject;

@Client
public class AccountClient {

    @Inject
    private RxHttpClient rxHttpClient;

    public Flowable<String> get(String cpf) {

        HttpRequest<?> req = HttpRequest.GET("http://account-svc:8080/account")
                .header("cpf", cpf);

        return rxHttpClient.retrieve(req, String.class);
    }
}