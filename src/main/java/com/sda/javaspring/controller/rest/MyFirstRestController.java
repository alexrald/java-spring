package com.sda.javaspring.controller.rest;

import com.sda.javaspring.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/rest")
public class MyFirstRestController {

    // Person Object is returned as JSON inside body of response
    @GetMapping("/one-person")
    public Person onePerson() {
        return new Person("Alexander", "Raldugin", 29);
    }

}
