package com.robcio.SpringStuffThymeleaf.controller.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.robcio.SpringStuffThymeleaf.enumeration.ItemType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class InventoryItemData {

    private Long userId;
    private String name;
    private ItemType type;
}
