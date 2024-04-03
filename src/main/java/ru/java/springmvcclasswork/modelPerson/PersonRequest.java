package ru.java.springmvcclasswork.modelPerson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequest {

    private String query;
    private Integer count;

}
