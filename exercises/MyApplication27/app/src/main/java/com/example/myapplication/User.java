package com.example.myapplication;

/**
 * Created by Aptivist-U001 on 10/19/2017.
 */

class User {

    private String firstName;
    private String latName;
    private String image;

    public User(String firstName, String latName, String image) {
        this.firstName = firstName;
        this.latName = latName;
        this.image = image;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLatName() {
        return latName;
    }

    public void setLatName(String latName) {
        this.latName = latName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
