package com.sda.javaspring.controller.rest;

import com.sda.javaspring.entity.Child;
import com.sda.javaspring.entity.Mother;
import com.sda.javaspring.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/rest")
public class MyFirstRestController {

    // Person Object is returned as JSON inside body of response
    @GetMapping("/one-person")
    public Person onePerson() {
        return new Person("Alexander", "Raldugin", 29);
    }

    @GetMapping("/persons")
    public List<Person> persons() {
        return List.of(
                new Person("John", "Doe", 99),
                new Person("Jane", "Roe", 33)
        );
    }

    @GetMapping("/persons-array")
    public Person[] personsArray() {
        return new Person[] {
                new Person("John", "Doe", 99),
                new Person("Jane", "Roe", 33)
        };
    }

    @GetMapping("/mother")
    public Mother motherAndChild() {
        return new Mother("Alice", new Child("Bob", "male"));
    }

}
