package com.robcio.SpringStuffThymeleaf.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.robcio.SpringStuffThymeleaf.dto.enumeration.UserStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private Set<InventoryItemData> items;
    private String status;
}