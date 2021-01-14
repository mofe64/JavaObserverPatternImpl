package com.nubari;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ObserverPatternTest {
    Subject publisher;
    Observer subscriber;

    @BeforeEach
    void setUp() {
        publisher = new Publisher("Mofe");
        subscriber = new Subscriber(publisher, "mofe_iv");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testObserversListIsInitializedWhenPublisherObjectCreated() {
        Publisher testPublisher = (Publisher) publisher;
        assertNotNull(testPublisher.getObservers());
    }

    @Test
    void testSubscriberIsRegisteredAsAnObserverWithTheSubjectWhenInitialized(){
        Publisher testPublisher = (Publisher) publisher;
        assertEquals(subscriber, testPublisher.getObservers().get(0));
    }

    @Test
    void testSubscriberIsNotifiedWhenSubjectCreatesANewPost(){
        Publisher testPublisher = (Publisher) publisher;
        testPublisher.addPost("Test title", "Test body");
        Subscriber newSubscriber = (Subscriber) subscriber;
        assertNotNull(newSubscriber.getLatestPost());
        publisher.notifyObservers("Latest status update");
    }


}
