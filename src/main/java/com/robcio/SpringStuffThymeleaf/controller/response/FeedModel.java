package com.robcio.SpringStuffThymeleaf.controller.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedModel {
    private String title;
    private String link;
    private String imgUrl;
    private String content;
}
