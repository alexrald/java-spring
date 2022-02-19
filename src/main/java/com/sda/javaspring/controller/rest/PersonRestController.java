package com.sda.javaspring.controller.rest;

import com.sda.javaspring.entity.PersonEntity;
import com.sda.javaspring.service.PersonService;
import com.sda.javaspring.service.RealPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
public class PersonRestController {

    private final RealPersonService personService;

    @Autowired
    public PersonRestController(RealPersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public List<PersonEntity> findAllPersons() {
        log.info("findAllPersons()");

        return personService.readAllPersonEntities();
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<PersonEntity> findPersonEntityById(@PathVariable("id") Long personId) {
        log.info("trying to find person entity by id: [{}]", personId);

        var personEntity = personService.readOptPersonEntityById(personId);

        return personEntity.map(personEntity1 -> ResponseEntity.ok(personEntity1))
                .orElseGet(() -> ResponseEntity.notFound().build());

//        PersonEntity personEntity = personService.readPersonEntityById(personId);
//
//        if (personEntity == null)
//            //return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
//            return ResponseEntity.notFound().build();
//
//        return ResponseEntity.ok(personEntity);
        //return new ResponseEntity<>(personEntity, null, HttpStatus.OK);
    }
}
