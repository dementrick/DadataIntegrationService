package ru.java.springmvcclasswork.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.java.springmvcclasswork.apiResponse.AddressApiResponse;
import ru.java.springmvcclasswork.apiResponse.PersonApiResponse;
import ru.java.springmvcclasswork.modelPerson.PersonRequest;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class Api {

    @Value("${dadata.apiKey}")
    private String apiKey;

    @Value("${dadata.personUrl}")
    private String personUrl;

    @Value("${dadata.addressUrl}")
    private String addressUrl;

    @Autowired
    private RestTemplate restTemplate;

    public PersonApiResponse makeCallToFioApi(PersonRequest request){
        String query = request.getQuery();
        Integer count = request.getCount() != null ? request.getCount() : 10;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "application/json");
        headers.add("Authorization", "Token " + apiKey);

        Map<String, Object> requestBody = Map.of(
                "query", query,
                "count", count
        );


        return restTemplate.postForObject(
                personUrl,
                new HttpEntity<>(requestBody, headers),
                PersonApiResponse.class
        );
    }

    public AddressApiResponse makeCallToAddressApi(String query, Integer count){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "application/json");
        headers.add("Authorization", "Token " + apiKey);

        Map<String, Object> requestBody = Map.of(
                "query", query,
                "count", count
        );

        return restTemplate.postForObject(
                addressUrl,
                new HttpEntity<>(requestBody, headers),
                AddressApiResponse.class
        );
    }
}
