package com.nubari;

import com.nubari.Post;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {
    Post post;
    @BeforeEach
    void setUp() {
        post = new Post("Test com.nubari.Post", "Test Body", "Test");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testPostShouldBeInitializedWithAuthorBodyAndTitle(){
        assertNotNull(post.getAuthor());
        assertNotNull(post.getBody());
        assertNotNull(post.getTitle());
    }

    @Test
    void testPostShouldBeAbleToChangeAuthor(){
        post.setAuthor("Mofe");
        assertEquals("Mofe", post.getAuthor());
    }

    @Test
    void testPostShouldBeAbleToChangeTitle(){
        post.setTitle("New Test title");
        assertEquals("New Test title", post.getTitle());
    }

    @Test
    void testPostShouldBeAbleToChangeBody(){
        post.setBody("New Test body");
        assertEquals("New Test body", post.getBody());
    }

}