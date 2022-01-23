package com.sda.javaspring.controller;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class FirstController {

    // The same as @Slf4j
    //private static final Logger log = LoggerFactory.getLogger(FirstController.class);

    @GetMapping("/my-first-page")
    public String firstPage() {
        log.info("firstPage() method called!");

        // looking for html page inside resources/templates
        // Spring please use page: resources/templates/home-page.html
        return "home-page";
    }

    @GetMapping("/my-second-page")
    public String secondPage() {
        log.info("secondPage() called");

        return "second-page";
    }

    @GetMapping("/my-third-page")
    public String thirdPage() {
        log.info("thirdPage() called");

        return "pages/third-page";
    }

}
