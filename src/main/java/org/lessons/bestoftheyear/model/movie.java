package org.lessons.bestoftheyear.model;

//movie
public class movie {
    //attribute
    private int id;
    private String name;

    //constructor
    public movie(int id, String name) {
        this.id = id;
        this.name = name;
    }
    //getter

    public String getName() {
        return name;
    }
}
