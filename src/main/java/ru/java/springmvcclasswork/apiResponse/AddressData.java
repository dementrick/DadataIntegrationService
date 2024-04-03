package ru.java.springmvcclasswork.apiResponse;

import lombok.Data;

@Data
public class AddressData {
    private String postalCode;
    private String country;
    private String city;
}
