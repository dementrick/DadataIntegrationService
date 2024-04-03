package ru.java.springmvcclasswork.apiResponse;

import lombok.Data;

import java.util.List;

@Data
public class AddressApiResponse {
    private List<AddressSuggestion> suggestions;
}
