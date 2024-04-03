package ru.java.springmvcclasswork.apiResponse;

import lombok.Data;

@Data
public class AddressSuggestion {
    private String value;
    private AddressData data;
}
