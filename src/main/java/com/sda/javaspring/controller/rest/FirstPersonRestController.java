package com.sda.javaspring.controller.rest;


import com.sda.javaspring.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/first-person")
public class FirstPersonRestController {

    // Person Object is returned as JSON inside body of response
    @GetMapping("/one-person")
    public ResponseEntity<Person> onePerson() {
        return ResponseEntity.ok(new Person("Alexander", "Raldugin", 29));
    }

    @GetMapping("/one-person-404")
    public ResponseEntity<Person> onePerson404() {
        log.info("onePerson404");
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/custom")
    public ResponseEntity<Person> customResponseEntity() {
        return new ResponseEntity<>(new Person("Johhn", "Doee", 20), HttpStatus.OK);
    }

}
