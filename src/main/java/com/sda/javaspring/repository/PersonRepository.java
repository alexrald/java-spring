package com.sda.javaspring.repository;

import com.sda.javaspring.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    // Based on the name of theat method Spring is going to build SQL query for us
    // Spring is using class properties to build the query: name, surname
    // Use it only for simple classes (short method names)
    // for complicated or long sql queries use @Query annotation
    boolean existsByNameAndSurname(String name, String surname);

    // We can provide our own query and Spring with Hibernate are going to use it
    // It is very useful for longer queries
    // We've got two options here:
    // using native sqls (with nativeQuery set to true) or JPQL (nativeQuery = false)
    // JPQL - Java Persistence Query Language - subset of SQL
    @Query(value = """
            SELECT COUNT (*) > 0
            FROM PERSON_ENTITIES
            WHERE name = :name AND surname = :surname
    """,
    nativeQuery = true)
    boolean checkDuplicates(String name, String surname);
}
