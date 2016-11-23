package com.namcha.com.namcha.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.namcha.controllers.ContentController;
import com.namcha.models.Content;
import com.namcha.services.ContentService;

/**
 * Created by archer on 11/22/2016 AD.
 */
@RunWith(SpringRunner.class)
public class ContentControllerTest {

	@InjectMocks
	private ContentController contentController;
	
	@Mock
	private ContentService contentService;
    
    @Test
    public void createContentSuccess() {
        Content content = new Content();
        content.setEventName("Namcha");

        String result = contentController.create(content);

        assertThat(result, equalTo("Success"));
    }

    @Ignore
    public void createContentShouldReturnFail_whenContentIsNull() {
        String result = contentController.create(null);

        assertThat(result, equalTo("Fail"));
    }

    @Test
    public void retrieveContent() {

        List<Content> contents = contentController.retrieve();

        assertThat(contents, notNullValue());
    }
}
