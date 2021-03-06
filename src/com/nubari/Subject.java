package com.nubari;

public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers(Post newPost);
    public void notifyObservers(String status);
}
