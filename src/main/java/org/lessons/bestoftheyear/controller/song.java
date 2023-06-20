package org.lessons.bestoftheyear.controller;

//song
public class song {
    //attribute
    private int id;
    private String name;

    //constructor
    public song(int id, String name) {
        this.id = id;
        this.name = name;
    }
    //getter

    public String getName() {
        return name;
    }
}
