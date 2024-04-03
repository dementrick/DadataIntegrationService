package ru.java.springmvcclasswork.modelAddress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String fullAddress;
    private String country;
    private String city;
    private String postalCode;
}
