package com.namcha.services;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.namcha.models.Content;
import com.namcha.repositories.ContentRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class ContentServiceTest {

	@InjectMocks
	private ContentService contentService;
	
	@Mock
	private ContentRepository contentRepository;
	
	@Test
	public void createShouldCallRepositorySave() {
		// Arrange
		Content content = new Content();
		when(contentRepository.save(content)).thenReturn(content);
		
		// Action
		Content actualResult = contentService.create(content);
		
		// Assert
		verify(contentRepository, times(1)).save(content);
		assertNotNull(actualResult);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void createWithNullShouldThrowException() {
		// Action
		contentService.create(null);
	}
}
