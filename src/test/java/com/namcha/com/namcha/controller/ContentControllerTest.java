package com.namcha.com.namcha.controller;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import com.namcha.controllers.ContentController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by archer on 11/22/2016 AD.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ContentControllerTest {

    @Test
    public void createContentSuccess(){

        ContentController content = new ContentController();
        String result = content.create();
        assertThat(result,equalTo("Success"));
    }
}
