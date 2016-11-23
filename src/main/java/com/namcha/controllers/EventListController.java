package com.namcha.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eventList")
public class EventListController {

    @RequestMapping(method=RequestMethod.GET)
    public String loadListRecord(){


        return "{json:success}";
    }
}
