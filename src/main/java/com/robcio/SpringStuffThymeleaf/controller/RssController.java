package com.robcio.SpringStuffThymeleaf.controller;

import com.robcio.SpringStuffThymeleaf.controller.response.FeedModel;
import com.robcio.SpringStuffThymeleaf.service.RssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@Controller
@RequestMapping(path = "/rss")
public class RssController {

    private final RssService rssService;

    @Autowired
    public RssController(final RssService rssService) {
        this.rssService = rssService;
    }

    @GetMapping(path = "/")
    public String getRssView(final Model model) {
        try {
            final List<FeedModel> rssList = rssService.getRss();
            model.addAttribute("rssList", rssList);
        } catch (final ResourceAccessException e) {
            final String errorMessage = "RSS server could not be reached";
            model.addAttribute("error", errorMessage);
        }
        return "rss";
    }
}
