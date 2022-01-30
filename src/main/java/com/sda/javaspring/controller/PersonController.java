package com.sda.javaspring.controller;

import com.sda.javaspring.entity.Person;
import com.sda.javaspring.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/person")
public class PersonController {

    public static final String PERSONS_KEY = "persons";
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService)
    {
        this.personService = personService;
    }

    @GetMapping("/names")
    public String showListOfPersonsNames(Model data) {
        //List<Person> persons
        var persons = personService.getAllPersons();

        data.addAttribute(PERSONS_KEY, persons);

        return "persons/persons-names";
    }

    @GetMapping("/details")
    public String showPersonsDetails(Model data) {

        data.addAttribute(PERSONS_KEY, personService.getAllPersons());
        return "persons/persons-table";
    }
}
