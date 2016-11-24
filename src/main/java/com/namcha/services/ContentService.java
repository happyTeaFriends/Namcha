package com.namcha.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namcha.models.Content;
import com.namcha.repositories.ContentRepository;

@Service
public class ContentService {

	@Autowired
	private ContentRepository contentRepository;

	public Content create(Content content) {
		if (content == null) {
			throw new IllegalArgumentException();
		}

		return contentRepository.save(content);
	}

	public Content get(String id) {
		return contentRepository.findOne(id);
	}
	
	public List<Content> retrieve(){

		List<Content> contents = new ArrayList<Content>();
		int count = 0;
		for (Content content: contentRepository.findAll())
		{
			count++;
			content.setCount(count);
			contents.add(content);
		}

		return contents;
	}
}
