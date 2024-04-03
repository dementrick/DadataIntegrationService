package ru.java.springmvcclasswork.apiResponse;

import lombok.Data;

import java.util.List;

@Data
public class PersonApiResponse {
    private List<PersonSuggestion> suggestions;
}
