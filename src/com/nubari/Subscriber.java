package com.nubari;

import java.util.ArrayList;

public class Subscriber implements Observer {

    private String userName;
    private Post latestPost;
    private ArrayList<Subject> publishersSubscribedTo;

    public Subscriber(Subject publisher, String userName) {
        publishersSubscribedTo = new ArrayList<>();
        this.userName = userName;
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

    public void addPublisher(Subject publisher) {
        publisher.registerObserver(this);
        publishersSubscribedTo.add(publisher);
    }

    public void removePublisher(Subject publisher) {
        publisher.removeObserver(this);
        publishersSubscribedTo.remove(publisher);
    }

    public String getUserName() {
        return userName;
    }

    public Post getLatestPost() {
        return latestPost;
    }

    public ArrayList<Subject> getPublishersSubscribedTo() {
        return publishersSubscribedTo;
    }
}
