package com.robcio.SpringStuffThymeleaf.service;

import com.robcio.SpringStuffThymeleaf.client.UserClient;
import com.robcio.SpringStuffThymeleaf.dto.InventoryItemData;
import com.robcio.SpringStuffThymeleaf.dto.User;
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

    public List<User> findAll() {
        return userClient.getAllUsers();
    }

    public void giveItem(final Long userId, final InventoryItemData item) {

    }

    public void createItem(final InventoryItemData itemData) {

    }
}
