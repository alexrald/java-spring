package com.sda.javaspring.service;

import com.sda.javaspring.entity.PersonEntity;
import com.sda.javaspring.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Optional<PersonEntity> readOptPersonEntityById(Long id) {
        log.info("read entity by id: [{}]", id);

        return personRepository.findById(id);
    }

    @Transactional
    public boolean deletePersonEntityById(Long id) {
        log.info("Deleting entity [{}]", id);

        if (!personRepository.existsById(id))
            return false;

        personRepository.deleteById(id);
        return true;
    }

    @Transactional
    public boolean savePerson(PersonEntity personEntity) {
        log.info("entity for saving: [{}]", personEntity);

        if (!personRepository.checkDuplicates(personEntity.getName(), personEntity.getSurname()) &&
            checkEntityValidity(personEntity)) {
            personRepository.save(personEntity);
            log.info("entity after saving: [{}]", personEntity);
            return true;
        }

        log.info("Duplicate item");
        return false;
    }

    private static boolean checkEntityValidity(PersonEntity personEntity) {
        boolean result = true;

        if ( (personEntity.getName() == null) || (personEntity.getName().isBlank()) )
            result = false;
        else if ( (personEntity.getSurname() == null) || (personEntity.getSurname().isBlank()) )
            result = false;
        else if (personEntity.getAge() < 0)
            return false;

        log.info("entity: [{}], valid: [{}]", personEntity, result);

        return result;
    }
}
