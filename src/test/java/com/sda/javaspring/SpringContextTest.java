package com.sda.javaspring;

import com.sda.javaspring.controller.FirstController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SpringContextTest {
    @Autowired
    private FirstController myFirstController;

    @Test
    void checkFirstControllerReference() {
        assertNotNull(myFirstController);
        String firstPageName = myFirstController.firstPage();
        assertEquals("home-page", firstPageName);
    }
}