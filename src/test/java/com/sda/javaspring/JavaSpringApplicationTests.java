package com.sda.javaspring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaSpringApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void dependencyInjectionFirstTrial() {
        Toy plasticGun = new Toy("plastic gun");

        Child john = new Child("John", plasticGun);

        // Dependency injection is providing all required class dependencies during creation of objects of that class
        // john (type Child) is dependency of jason (type Parent)
        // dependency is actually composition, so one item is made of another
        Parent jason = new Parent("Jason", john);
    }

}

record Toy(String name) {}
record Child(String name, Toy favouriteToy) {}
record Parent(String name, Child child) {

}