package com.robcio.SpringStuffThymeleaf.service;

import com.robcio.SpringStuffThymeleaf.client.UserClient;
import com.robcio.SpringStuffThymeleaf.controller.request.UserRequest;
import com.robcio.SpringStuffThymeleaf.controller.response.InventoryItemData;
import com.robcio.SpringStuffThymeleaf.controller.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    private final UserClient userClient;

    @Autowired
    public UserService(final UserClient userClient) {
        this.userClient = userClient;
    }

    public List<UserResponse> getAll() {
        return userClient.getAllUsers();
    }

    public UserResponse getOne(final Long userId) {
        return userClient.getUser(userId);
    }

    public void giveItem(final Long userId, final InventoryItemData item) {

    }

    public void createItem(final InventoryItemData itemData) {

    }

    public Long add(final UserRequest user) {
        return userClient.addUser(user);
    }
}
