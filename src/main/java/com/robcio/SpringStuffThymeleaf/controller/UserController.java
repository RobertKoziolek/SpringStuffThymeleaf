package com.robcio.SpringStuffThymeleaf.controller;

import com.robcio.SpringStuffThymeleaf.dto.InventoryItemData;
import com.robcio.SpringStuffThymeleaf.dto.User;
import com.robcio.SpringStuffThymeleaf.dto.enumeration.ItemType;
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
    public String add(@ModelAttribute final User user) {
        return "redirect:/users/";
    }

    @GetMapping(path = "/")
    public String getAllUsers(final Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @PostMapping(path = "/items/add")
    public String addItem(@ModelAttribute final InventoryItemData itemData) {
        return "redirect:/users/items/1";
    }

    @GetMapping(path = "/items/add/")
    public String addItemView(final Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("itemTypes", ItemType.values());
        return "add_item";
    }
}
