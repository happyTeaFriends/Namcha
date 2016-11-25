package com.namcha.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class ContentTest {

    @Spy
    Content content;

    String mockText = "test";
    Date mockDate = new Date();

    @Test
    public void testGetId() {
        content.setId(mockText);
        assertEquals(mockText, content.getId());
    }

    @Test
    public void testGetCategory() {
        content.setCategory(mockText);
        assertEquals(mockText, content.getCategory());
    }

    @Test
    public void testGetEventName() {
        content.setEventName(mockText);
        assertEquals(mockText, content.getEventName());
    }

    @Test
    public void testGetStartDate() {
        content.setStartDate(mockDate);
        assertEquals(mockDate, content.getStartDate());
    }

    @Test
    public void testGetEndDate() {
        content.setEndDate(mockDate);
        assertEquals(mockDate, content.getEndDate());
    }

    @Test
    public void testGetLocation() {
        content.setLocation(mockText);
        assertEquals(mockText, content.getLocation());
    }

    @Test
    public void testGetDescription() {
        content.setDescription(mockText);
        assertEquals(mockText, content.getDescription());
    }

}
