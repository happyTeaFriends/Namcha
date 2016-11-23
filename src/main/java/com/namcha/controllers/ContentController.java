package com.namcha.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.namcha.models.Content;
import com.namcha.services.ContentService;

/**
 * Created by archer on 11/22/2016 AD.
 */
@RestController
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService contentService;

	@RequestMapping(method = RequestMethod.POST, path = "/create")
	public String create(Content content) {

		try {
			contentService.create(content);
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
