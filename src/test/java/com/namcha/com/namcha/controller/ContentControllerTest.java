package com.namcha.com.namcha.controller;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
	public void createShouldCallContentServiceCreate() {
		// Arrange
		Content content = new Content();
		when(contentService.create(content)).thenReturn(content);

		// Action
		Content actualResult = contentController.create(content);

		// Assert
		verify(contentService, times(1)).create(content);
		assertNotNull(actualResult);
	}

	@Test
	public void getAllContent() {
		// Arrange
		List<Content> contents = new ArrayList<Content>();
		contents.add(new Content());
		when(contentService.retrieve()).thenReturn(contents);
		
		// Action
		List<Content> actualResult = contentController.getAll();
		
		// Assert
		verify(contentService, times(1)).retrieve();
		assertEquals(contents.size(), actualResult.size());
	}
}
