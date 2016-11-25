package com.namcha.services;

import com.namcha.models.Content;
import com.namcha.repositories.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContentService {

    @Autowired
    private ContentRepository contentRepository;

    public Content create(Content content) {
        return contentRepository.save(content);
    }

    public Content get(String id) {
        return contentRepository.findOne(id);
    }

    public List<Content> retrieve() {
        List<Content> contents = contentRepository.findAllByOrderByStartDateAsc();
        int count = 0;
        for (Content content : contents) {
            count++;
            content.setCount(count);
        }
        return contents;
    }
}
