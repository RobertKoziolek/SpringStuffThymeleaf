package com.robcio.SpringStuffThymeleaf.service;

import com.robcio.SpringStuffThymeleaf.client.RssClient;
import com.robcio.SpringStuffThymeleaf.dto.FeedModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RssService {

    private final RssClient rssClient;

    @Autowired
    public RssService(final RssClient rssClient) {
        this.rssClient = rssClient;
    }

    public List<FeedModel> getRss() {
        return rssClient.getRss();
    }
}
