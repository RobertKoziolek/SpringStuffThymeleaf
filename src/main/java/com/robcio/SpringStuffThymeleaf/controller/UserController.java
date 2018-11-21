package com.robcio.SpringStuffThymeleaf.controller;

import com.robcio.SpringStuffThymeleaf.controller.request.UserRequest;
import com.robcio.SpringStuffThymeleaf.controller.response.InventoryItemData;
import com.robcio.SpringStuffThymeleaf.enumeration.ItemType;
import com.robcio.SpringStuffThymeleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/add")
    public String add(@ModelAttribute final UserRequest userRequest) {
        final Long userId = userService.add(userRequest);
        return "redirect:/users/" + userId;
    }

    @GetMapping(path = "/")
    public String getAllUsers(final Model model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @GetMapping(path = "/{userId}")
    public String getUser(@PathVariable final Long userId, final Model model) {
        model.addAttribute("user", userService.getOne(userId));
        return "user";
    }

    @PostMapping(path = "/items/add")
    public String addItem(@ModelAttribute final InventoryItemData itemData) {
        return "redirect:/users/items/1";
    }

    @GetMapping(path = "/items/add/")
    public String addItemView(final Model model) {
        model.addAttribute("users", userService.getAll());
        model.addAttribute("itemTypes", ItemType.values());
        return "add_item";
    }
}
