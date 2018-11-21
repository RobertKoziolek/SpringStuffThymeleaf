package com.robcio.SpringStuffThymeleaf.client;

import com.robcio.SpringStuffThymeleaf.configuration.UserRestTemplateConfiguration;
import com.robcio.SpringStuffThymeleaf.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class UserClient {

    private final UserRestTemplateConfiguration configuration;

    private final RestTemplate rssRestTemplate;

    @Autowired
    public UserClient(final UserRestTemplateConfiguration configuration,
                      @Qualifier("userRestTemplate") final RestTemplate restTemplate) {
        this.configuration = configuration;
        this.rssRestTemplate = restTemplate;
    }

    public List<User> getAllUsers() {
        return rssRestTemplate.exchange(configuration.getAllUsers(),
                                        HttpMethod.GET, null,
                                        new ParameterizedTypeReference<List<User>>() {
                                        })
                              .getBody();
    }
}
