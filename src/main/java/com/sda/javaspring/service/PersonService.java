package com.sda.javaspring.service;

import com.sda.javaspring.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    public List<Person> getAllPersons()
    {
        //List<Person> persons
        var persons         // same as above
                = List.of(
                new Person("Alexander", "Raldugin", 29),
                new Person("John", "Doe", 50),
                new Person("Jane", "Foe", 25)
        );

        return persons;

    }
}
