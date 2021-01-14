package com.nubari;

public class main {
    public static void main(String[] args) {
        Publisher publisher = new Publisher("Mofe");
        Publisher publisher1 = new Publisher("Tayo");
        Publisher publisher2 = new Publisher("Tade");

        Subscriber subscriber = new Subscriber(publisher, "mofe_iv");
        subscriber.addPublisher(publisher1);
        publisher.addPost("Test", "tEST BODY YYY");
        subscriber.removePublisher(publisher);
        System.out.println();
        publisher.addPost("Test", "test body");
        publisher1.addPost("Test 1", "test");
        subscriber.removePublisher(publisher1);
        publisher1.addPost("new post", "tes body");
    }

}
