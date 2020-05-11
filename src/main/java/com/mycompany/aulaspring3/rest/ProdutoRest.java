package com.mycompany.aulaspring3.rest;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;

@Service
public class ProdutoRest {

    private final RestTemplate restTemplate;

    public ProdutoRest(RestTemplateBuilder builder) {
        this.restTemplate = builder
                .setConnectTimeout(Duration.ofSeconds(700))
                .setReadTimeout(Duration.ofSeconds(700))
                .errorHandler(new ResponseErrorHandler() {
                    @Override
                    public boolean hasError(ClientHttpResponse response) throws IOException {
                        return false;
                    }

                    @Override
                    public void handleError(ClientHttpResponse response) throws IOException {

                    }
                })
                .build();
    }

    public Object post(String uri, Object object) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        Class className = object.getClass();

        HttpEntity<?> entity = new HttpEntity<>(object, headers);

        ResponseEntity<?> response = this.restTemplate.postForEntity(uri, entity, className);

        if (response.getStatusCode() == HttpStatus.CREATED) {
            return response.getBody();
        } else {
            return null;
        }
    }

    public Object get(String uri, Class className, int id) {
        uri += "/{id}";
        return this.restTemplate.getForObject(uri, className, id);
    }

    public String getAsJSON(String uri) {
        return this.restTemplate.getForObject(uri, String.class);
    }

    public void delete(String uri, int id) {
        uri += "/{id}";
        this.restTemplate.delete(uri, id);
    }

    public Object put(String uri, Object object, int id) {
        uri += "/{id}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<?> entity = new HttpEntity<>(object, headers);
        Class className = object.getClass();
        ResponseEntity<?> response = this.restTemplate.exchange(uri, HttpMethod.PUT, entity, className, id);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }


}
