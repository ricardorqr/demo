package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController()
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping()
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping()
    public Iterable<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person getPersonByID(@PathVariable(value = "id") UUID id) {
        return personService.getPersonByID(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePerson(@PathVariable(value = "id") UUID id) {
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable(value = "id") UUID id, @RequestBody Person person) {
        personService.updatePerson(id, person);
    }

}
