package com.robcio.SpringStuffThymeleaf.dto;

import com.robcio.SpringStuffThymeleaf.dto.enumeration.ItemType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryItemData {

    private Long userId;

    private String name;

    private ItemType type;
}
