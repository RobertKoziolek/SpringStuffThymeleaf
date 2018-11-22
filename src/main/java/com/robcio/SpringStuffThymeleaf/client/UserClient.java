package com.robcio.SpringStuffThymeleaf.client;

import com.robcio.SpringStuffThymeleaf.configuration.UserRestTemplateConfiguration;
import com.robcio.SpringStuffThymeleaf.controller.request.UserRequest;
import com.robcio.SpringStuffThymeleaf.controller.response.InventoryItemData;
import com.robcio.SpringStuffThymeleaf.controller.response.UserResponse;
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

    private final RestTemplate userRestTemplate;

    @Autowired
    public UserClient(final UserRestTemplateConfiguration configuration,
                      @Qualifier("userRestTemplate") final RestTemplate restTemplate) {
        this.configuration = configuration;
        this.userRestTemplate = restTemplate;
    }

    public List<UserResponse> getAllUsers() {
        return userRestTemplate.exchange(configuration.getAllUsers(),
                                         HttpMethod.GET, null,
                                         new ParameterizedTypeReference<List<UserResponse>>() {
                                         })
                               .getBody();
    }

    public UserResponse getUser(final Long userId) {
        return userRestTemplate.exchange(configuration.getUser(),
                                         HttpMethod.GET, null,
                                         new ParameterizedTypeReference<UserResponse>() {
                                         }, userId)
                               .getBody();
    }

    public Long addUser(final UserRequest user) {
        return userRestTemplate.postForObject(configuration.getAddUser(), user, Long.class);
    }

    public Long addItem(final InventoryItemData itemData) {
        return userRestTemplate.postForObject(configuration.getAddItem(), itemData, Long.class, itemData.getUserId());
    }
}
