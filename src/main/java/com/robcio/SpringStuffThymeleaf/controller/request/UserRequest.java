package com.robcio.SpringStuffThymeleaf.controller.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequest {
    private String name;
    private String email;
    private Integer age;
}
