package com.namcha.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/list")
public class EventListController {

    @RequestMapping(value="html", method=RequestMethod.GET)
    public String index() {
        return "../index.html";
    }

    public String loadListRecord(){
        

        return "";
    }
}
