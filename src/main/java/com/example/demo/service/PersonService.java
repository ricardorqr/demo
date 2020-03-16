package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.FakePersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    @Autowired
    private FakePersonRepository personRepository;

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public Iterable<Person> getAllPeople() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonByID(UUID id) {
        return personRepository.getPerson(id);
    }

    public boolean deletePerson(UUID id) {
        return personRepository.deletePerson(id);
    }

    public boolean updatePerson(UUID id, Person person) {
        return personRepository.updatePerson(id, person);
    }

}
