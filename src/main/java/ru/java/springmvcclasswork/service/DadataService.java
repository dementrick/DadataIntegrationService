package ru.java.springmvcclasswork.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import ru.java.springmvcclasswork.apiResponse.AddressApiResponse;
import ru.java.springmvcclasswork.apiResponse.AddressSuggestion;
import ru.java.springmvcclasswork.apiResponse.PersonApiResponse;
import ru.java.springmvcclasswork.apiResponse.PersonSuggestion;
import ru.java.springmvcclasswork.modelAddress.Address;
import ru.java.springmvcclasswork.modelPerson.Person;
import ru.java.springmvcclasswork.modelPerson.PersonRequest;

import java.util.*;


@Service
@RequiredArgsConstructor
@Slf4j
public class DadataService {

    private final Api api;

    public List<Person> getForFullName(PersonRequest request){
        List<Person> personList = new ArrayList<>();
        PersonApiResponse response = api.makeCallToFioApi(request);
        if (response != null && response.getSuggestions() != null){
            for (PersonSuggestion personSuggestion : response.getSuggestions()){
                Person person = new Person();
                person.setFullName(personSuggestion.getValue());
                person.setGender(mapGender(personSuggestion.getData().getGender()));
                personList.add(person);
            }
        }
        return personList;
    }
    public List<Address> getForAddress(String query, int count){
        List<Address> addresses = new ArrayList<>();
        AddressApiResponse response = api.makeCallToAddressApi(query, count);
        if (response != null && response.getSuggestions() != null){
            for (AddressSuggestion addressSuggestion : response.getSuggestions()){
                Address address = new Address();
                address.setFullAddress(addressSuggestion.getValue());
                address.setCountry(addressSuggestion.getData().getCountry());
                address.setCity(addressSuggestion.getData().getCity());
                address.setPostalCode(addressSuggestion.getData().getPostalCode());
                addresses.add(address);
            }
        }
        return addresses;
    }
    private Person.Gender mapGender(String gender){
        return switch (gender.toUpperCase()) {
            case "MALE" -> Person.Gender.MALE;
            case "FEMALE" -> Person.Gender.FEMALE;
            default -> Person.Gender.UNKNOWN;
        };
    }


}
