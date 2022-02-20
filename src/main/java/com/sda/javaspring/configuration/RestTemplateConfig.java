package com.sda.javaspring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration      // This class is able produce many Spring beans
public class RestTemplateConfig {

    @Bean       // This method is producing new bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
