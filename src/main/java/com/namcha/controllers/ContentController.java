package com.namcha.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(method = RequestMethod.POST)
	public Content create(@RequestBody Content content) {
		return contentService.create(content);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Content> getAll() {

		Content content = new Content();
		content.setEventName("Programming");

		List<Content> contents = new ArrayList<Content>();
		contents.add(content);
		return contents;
	}
}
