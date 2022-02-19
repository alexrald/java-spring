package com.sda.javaspring.service;

import com.sda.javaspring.entity.PersonEntity;
import com.sda.javaspring.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RealPersonService {

    private final PersonRepository personRepository;

    public RealPersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonEntity> readAllPersonEntities() {
        log.info("Trying to read all persons entities");

        var result = personRepository.findAll();
        log.info("persons entities read from db: {}", result);

        return result;
    }

    public PersonEntity readPersonEntityById(Long id) {
        log.info("read entity by id: [{}]", id);

        Optional<PersonEntity> maybePerson = personRepository.findById(id);
        PersonEntity result = null;

        if (maybePerson.isPresent()) {
            result = maybePerson.get();
        }
        return result;
    }
}
