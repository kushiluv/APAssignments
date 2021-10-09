package com.company;

public class citizen {
    private String name;
    private int age;
    private int uniqueid;

    public citizen(String name, int age, int uniqueid) {
        this.name = name;
        this.age = age;
        this.uniqueid = uniqueid;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getUniqueid() {
        return uniqueid;
    }
}

