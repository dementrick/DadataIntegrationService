package ru.java.springmvcclasswork.modelPerson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String fullName;
    private Gender gender;

    public enum Gender {
        MALE,
        FEMALE,
        UNKNOWN
    }
}

