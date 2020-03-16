package com.example.demo.repository;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class FakePersonRepository {

    private List<Person> personList = new ArrayList<>();

    public void save(Person person) {
        personList.add(person);
    }

    public List<Person> findAll() {
        return personList;
    }

    public Optional<Person> getPerson(UUID id) {
        return personList
                .stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    public boolean deletePerson(UUID id) {
        Optional<Person> personOptional = getPerson(id);
        if (!personOptional.isPresent()) {
            return false;
        }

        personList.remove(personOptional.get());
        return true;
    }

    public boolean updatePerson(UUID id, Person newPerson) {
        return getPerson(id)
                .map(p -> {
                    int indexOfPersonToDelete = personList.indexOf(p);
                    if (indexOfPersonToDelete >= 0) {
                        personList.set(indexOfPersonToDelete, new Person(id, newPerson.getName()));
                        return true;
                    }
                    return false;
                })
                .orElse(false);
    }

}
