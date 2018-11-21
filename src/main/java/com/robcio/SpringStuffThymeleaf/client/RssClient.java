package com.robcio.SpringStuffThymeleaf.client;

import com.robcio.SpringStuffThymeleaf.configuration.RssSimplifierRestTemplateConfiguration;
import com.robcio.SpringStuffThymeleaf.controller.response.FeedModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class RssClient {

    private final RssSimplifierRestTemplateConfiguration configuration;

    private final RestTemplate rssRestTemplate;

    @Autowired
    public RssClient(final RssSimplifierRestTemplateConfiguration configuration,
                     @Qualifier("rssRestTemplate") final RestTemplate restTemplate) {
        this.configuration = configuration;
        this.rssRestTemplate = restTemplate;
    }

    public List<FeedModel> getRss() {
        return rssRestTemplate.exchange(configuration.getRssPath(),
                                        HttpMethod.GET, null,
                                        new ParameterizedTypeReference<List<FeedModel>>() {
                                        })
                              .getBody();
    }
}
