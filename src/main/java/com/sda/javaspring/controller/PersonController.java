package com.sda.javaspring.controller;

import com.sda.javaspring.entity.Person;
import lombok.extern.slf4j.Slf4j;
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

    @GetMapping("/names")
    public String showListOfPersonsNames(Model data) {
        //List<Person> persons
        var persons         // same as above
                = List.of(
                new Person("Alexander", "Raldugin", 29),
                new Person("John", "Doe", 50),
                new Person("Jane", "Foe", 25)
        );

        data.addAttribute(PERSONS_KEY, persons);

        return "persons/persons-names";
    }
}
