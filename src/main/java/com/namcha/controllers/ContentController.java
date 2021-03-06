package com.namcha.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.namcha.models.Content;
import com.namcha.services.ContentService;

@RestController
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping(method = RequestMethod.POST)
    public Content create(Content content) {
        return contentService.create(content);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Content> getAll() {

        return contentService.retrieve();
    }
    
    @RequestMapping(path="{id}", method = RequestMethod.GET)
    public Content getContentByid(@PathVariable String id) {

    	return contentService.get(id);
    }
}
