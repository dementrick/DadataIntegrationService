package ru.java.springmvcclasswork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.java.springmvcclasswork.modelAddress.Address;
import ru.java.springmvcclasswork.modelPerson.Person;
import ru.java.springmvcclasswork.modelPerson.PersonRequest;
import ru.java.springmvcclasswork.service.DadataService;

import java.util.List;

@RestController
@RequestMapping("/api")

public class DadataController {

    private final DadataService dadataService;

    @Autowired
    public DadataController(DadataService dadataService) {
        this.dadataService = dadataService;
    }


    @PostMapping("/person")
    @PreAuthorize("hasAuthority('ROLE_USER') || hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Person>> cluesPerson(@RequestBody PersonRequest request){
        try {
            List<Person> personList = dadataService.getForFullName(request);
            return ResponseEntity.ok(personList);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }

    @GetMapping("/address")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Address>> cluesAddress(@RequestParam String query, @RequestParam(required = false, defaultValue = "10") int count) {
        try {
            List<Address> addresses = dadataService.getForAddress(query, count);
            return ResponseEntity.ok(addresses);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping("/welcome")
    public String home(){
        return "Welcome";
    }
}
