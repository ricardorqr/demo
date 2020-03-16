package com.example.demo.model;

import java.util.UUID;

//@Entity
public class Person {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String name;

    public Person(UUID id, String name) {
        if (id == null) {
            this.id = UUID.randomUUID();
        } else {
            this.id = id;
        }
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
