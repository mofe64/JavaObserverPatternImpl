package com.nubari;

import java.util.ArrayList;

public class Subscriber implements Observer {
    private Post latestPost;
    private ArrayList<Subject> publishersSubscribedTo;

    public Subscriber(Subject publisher) {
        publishersSubscribedTo.add(publisher);
        publisher.registerObserver(this);
    }

    public void update(Post post) {
        latestPost = post;
        System.out.println("New post created by " + latestPost.getAuthor());
    }

    public void update(String statusUpdate, String publisherName) {
        System.out.println("New status update by: " + publisherName + "\n" +
                "Status: " + statusUpdate);

    }
}
