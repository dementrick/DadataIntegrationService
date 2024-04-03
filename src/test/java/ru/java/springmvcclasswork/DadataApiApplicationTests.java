package ru.java.springmvcclasswork;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import ru.java.springmvcclasswork.modelAddress.Address;
import ru.java.springmvcclasswork.modelPerson.Person;
import ru.java.springmvcclasswork.service.Api;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static ru.java.springmvcclasswork.TestDataProvider.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration
@ActiveProfiles({"test"})
@AutoConfigureMockMvc
public class DadataApiApplicationTests {

    private static final String PERSON_PATH = "/api/person";

    @Autowired
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private String PORT;

    @MockBean
    private Api api;

    @Test
    public void testGetForFullName() {
        when(api.makeCallToFioApi(createPersonRequest())).thenReturn(createPersonResponseEntity());

        ResponseEntity<List<Person>> response = restTemplate.exchange("http://localhost:" + PORT + PERSON_PATH,
                HttpMethod.POST,
                new HttpEntity<>(createPersonRequest()),
                new ParameterizedTypeReference<>() {}
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(createCluesPersonResponse(), response.getBody());
    }

    @Test
    public void testGetForAddress() {
        when(api.makeCallToAddressApi("москва хабар", 2)).thenReturn(createAddressResponseEntity());

        ResponseEntity<List<Address>> response = restTemplate.exchange(
                "http://localhost:" + PORT + "/api/address?query=москва хабар&count=2",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {});

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(createCluesAddressResponse(), response.getBody());
    }
}
