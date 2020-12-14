package com.nubari;

import java.util.ArrayList;

public class Publisher implements Subject {
    private final String publisherName;
    private ArrayList<Observer> observers;
    private ArrayList<Post> posts;
    private String status;
    private Post latestPost;

    public Publisher(String publisherName) {
        posts = new ArrayList<>();
        observers = new ArrayList<>();
        this.publisherName = publisherName;
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }


    public void removeObserver(Observer observer) {
        int indexOfObserver = observers.indexOf(observer);
        //System.out.println("Index of observer is " + indexOfObserver);
        if (indexOfObserver >= 0) {
            observers.remove(indexOfObserver);
        }
    }

    public void notifyObservers(Post post) {
        for (Observer subscriber : observers) {
            subscriber.update(post);
        }
    }

    public void notifyObservers(String newStatus) {
        for (Observer subscriber : observers) {
            subscriber.update(newStatus, publisherName);
        }
    }

    public void addPost(String title, String body) {
        Post newPost = new Post(title, body, this.publisherName);
        latestPost = newPost;
        posts.add(newPost);
        notifyObservers(latestPost);
    }

    public void newStatus(String message) {
        status = message;
        notifyObservers(status);
    }
}
