package com.nubari;

public interface Observer {
    public void update(Post post);
    public void update(String status, String publisherName);
}
