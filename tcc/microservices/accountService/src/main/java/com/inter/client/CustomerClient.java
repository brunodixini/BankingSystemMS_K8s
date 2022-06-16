package com.inter.client;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Flowable;

import javax.inject.Inject;

import static io.micronaut.http.HttpRequest.GET;

@Client
public class CustomerClient {

    @Inject
    private RxHttpClient rxHttpClient;

    public Flowable<String> getUSerInfo(String cpf) {

        HttpRequest<?> req = HttpRequest.GET("http://customer-svc:8080/customer")
                .header("cpf", cpf);

        return rxHttpClient.retrieve(req, String.class);
    }
}