package com.namcha.services;

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
}
