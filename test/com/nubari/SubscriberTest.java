package com.nubari;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubscriberTest {
    Subscriber subscriber;
    Publisher publisher;

    @BeforeEach
    void setUp() {
        publisher = new Publisher("mofe_iv");
        subscriber = new Subscriber(publisher, "mofe");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testSubscriberObjectInitializedWithValues() {
        assertNotNull(subscriber.getUserName());
        assertNotNull(subscriber.getPublishersSubscribedTo());
    }

    @Test
    void testAddPublisherAddsAPublisherToPublishersList() {
        Publisher publisher = new Publisher("Test");
        subscriber.addPublisher(publisher);
        assertEquals(2, subscriber.getPublishersSubscribedTo().size());
        assertEquals(publisher, subscriber.getPublishersSubscribedTo().get(1));
    }

    @Test
    void testRemovePublisherRemovesPublisherFromPublishersList() {
        Publisher publisher = new Publisher("Test");
        subscriber.addPublisher(publisher);
        assertEquals(2, subscriber.getPublishersSubscribedTo().size());
        assertEquals(publisher, subscriber.getPublishersSubscribedTo().get(1));
        subscriber.removePublisher(publisher);
        assertEquals(1, subscriber.getPublishersSubscribedTo().size());
        assertNotEquals(publisher, subscriber.getPublishersSubscribedTo().get(0));
    }
}