package com.namcha.com.namcha.controller;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import com.namcha.controllers.ContentController;
import com.namcha.models.Content;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by archer on 11/22/2016 AD.
 */
@RunWith(SpringRunner.class)
public class ContentControllerTest {

    ContentController controller;

    @Before
    public void setup() {
        controller = new ContentController();
    }

    @Test
    public void createContentSuccess() {
        Content content = new Content();
        content.setEventName("Namcha");

        String result = controller.create(content);

        assertThat(result, equalTo("Success"));
    }

    @Test
    public void createContentShouldReturnFail_whenEventNameIsEmpty() {
        Content content = new Content();

        String result = controller.create(content);

        assertThat(result, equalTo("Fail"));
    }

    @Test
    public void retrieveContent() {

        List<Content> contents = controller.retrieve();

        assertThat(contents, notNullValue());
    }
}
