package com.sda.javaspring.controller.rest;

import com.sda.javaspring.entity.PersonEntity;
import com.sda.javaspring.service.PersonService;
import com.sda.javaspring.service.RealPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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

    @DeleteMapping("/persons/{id}")
    public ResponseEntity<Void> deletePersonEntityById(@PathVariable("id") Long id) {
        log.info("Trying to delete person entity [{}]", id);

        if (personService.deletePersonEntityById(id))
            return ResponseEntity.noContent().build();

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/persons")
    public ResponseEntity<?> createPersonEntity(@RequestBody PersonEntity personEntity) {
        log.info("received new person to save: [{}]", personEntity);

        boolean result = personService.savePerson(personEntity);

        if (result)
            return ResponseEntity
                    .created(URI.create("/api/persons/%d".formatted(personEntity.getId())))
                    .body(personEntity);

        else
            return ResponseEntity.badRequest().body("Incorrect data or duplicate detected");

    }
}
