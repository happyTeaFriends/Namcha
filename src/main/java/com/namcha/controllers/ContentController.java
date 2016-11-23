package com.namcha.controllers;

import java.time.OffsetDateTime;
import java.util.*;

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

	@RequestMapping(method = RequestMethod.POST)
	public Content create(Content content) {
		return contentService.create(content);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Content> getAll() {

		OffsetDateTime now = OffsetDateTime.now();

		Content content1 = new Content();
		content1.setId("111");
		content1.setCategory("Programming");
		content1.setEventName("Certified Scrum Developer");
		content1.setStartDate(now);
		content1.setEndDate(now.plusDays(2));

		Content content2 = new Content();
		content2.setId("222");
		content2.setCategory("Sharing");
		content2.setEventName("How to Lose a Guy in 10 Days");
		content2.setStartDate(now);
		content2.setEndDate(now.plusDays(2));

		List<Content> contents = new ArrayList<Content>();
		contents.add(content1);
		contents.add(content2);

		return contents;
	}
}
