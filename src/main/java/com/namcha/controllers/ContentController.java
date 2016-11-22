package com.namcha.controllers;

import com.namcha.models.Content;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by archer on 11/22/2016 AD.
 */
@RestController
@RequestMapping("/content")
public class ContentController {

    @RequestMapping(method = RequestMethod.POST, path = "/create")
    public String create(Content content) {

        try {
            // assume that service should throw an exception when error occured
            if (content.getEventName().isEmpty()) {
                throw new Exception();
            }
        } catch (Exception e) {
            return "Fail";
        }

        return "Success";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/retrieve")
    public List<Content> retrieve() {
        Content content = new Content();
        content.setEventName("Programming");

        List<Content> contents = new ArrayList<Content>();
        contents.add(content);

        return contents;
    }
}
