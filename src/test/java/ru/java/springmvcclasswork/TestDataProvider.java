package ru.java.springmvcclasswork;

import ru.java.springmvcclasswork.apiResponse.AddressApiResponse;
import ru.java.springmvcclasswork.apiResponse.AddressData;
import ru.java.springmvcclasswork.apiResponse.AddressSuggestion;
import ru.java.springmvcclasswork.apiResponse.PersonApiResponse;
import ru.java.springmvcclasswork.apiResponse.PersonData;
import ru.java.springmvcclasswork.apiResponse.PersonSuggestion;
import ru.java.springmvcclasswork.modelAddress.Address;
import ru.java.springmvcclasswork.modelPerson.Person;
import ru.java.springmvcclasswork.modelPerson.PersonRequest;

import java.util.ArrayList;
import java.util.List;

import static ru.java.springmvcclasswork.modelPerson.Person.Gender.FEMALE;
import static ru.java.springmvcclasswork.modelPerson.Person.Gender.MALE;

public class TestDataProvider {
    public static List<Person> createCluesPersonResponse(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Виктор", MALE));
        personList.add(new Person("Виктория", FEMALE));
        return personList;
    }

    public static List<Address> createCluesAddressResponse(){
        List<Address> addresses = new ArrayList<>();
        addresses.add(new Address("г Москва, ул Хабаровская", "Россия","Москва",null));
        return addresses;
    }

    public static PersonApiResponse createPersonResponseEntity() {
        PersonData person1 = new PersonData();
        person1.setGender("MALE");
        PersonSuggestion personSuggestionPerson1 = new PersonSuggestion();
        personSuggestionPerson1.setData(person1);
        personSuggestionPerson1.setValue("Виктор");

        PersonData person2 = new PersonData();
        person2.setGender("FEMALE");
        PersonSuggestion personSuggestionPerson2 = new PersonSuggestion();
        personSuggestionPerson2.setData(person2);
        personSuggestionPerson2.setValue("Виктория");

        List<PersonSuggestion> personSuggestions = new ArrayList<>();
        personSuggestions.add(personSuggestionPerson1);
        personSuggestions.add(personSuggestionPerson2);

        PersonApiResponse response = new PersonApiResponse();
        response.setSuggestions(personSuggestions);
        return response;
    }

    public static AddressApiResponse createAddressResponseEntity() {
        AddressData address = new AddressData();
        address.setPostalCode(null);
        address.setCity("Москва");
        address.setCountry("Россия");
        AddressSuggestion addressSuggestion = new AddressSuggestion();
        addressSuggestion.setData(address);
        addressSuggestion.setValue("г Москва, ул Хабаровская");

        List<AddressSuggestion> addressSuggestions = new ArrayList<>();
        addressSuggestions.add(addressSuggestion);

        AddressApiResponse response = new AddressApiResponse();
        response.setSuggestions(addressSuggestions);
        return response;
    }

    public static PersonRequest createPersonRequest(){
        return new PersonRequest("Викт", 2);
    }
}
