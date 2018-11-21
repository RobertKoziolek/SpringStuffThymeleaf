package com.robcio.SpringStuffThymeleaf.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class UserRestTemplateConfiguration {

    @Value("${userstuff.host}")
    private String host;

    @Value("${userstuff.port}")
    private String port;

    @Getter
    @Value("${userstuff.users.getAll}")
    private String allUsers;

    @Getter
    @Value("${userstuff.users.addUser}")
    private String addUser;

    @Getter
    @Value("${userstuff.users.addItem}")
    private String addItem;

    @Getter
    @Value("${userstuff.users.getItemsByUser}")
    private String itemsByUser;

    @Bean
    public RestTemplate userRestTemplate() {
        final RestTemplate restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(String.format("%s:%s", host, port)));
        return restTemplate;
    }
}
