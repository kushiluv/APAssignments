package com.company;
 class citizen {
    String name;
    int age;
    int uniqueid;

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
 class hospital {
    String name;
    int pincode;
    int uniqueid;

    public hospital(String name, int pincode) {
        this.name = name;
        this.pincode = pincode;
    }

    public String getName() {
        return name;
    }

    public int getPincode() {
        return pincode;
    }
}



public class Main {

    public static void main(String[] args) {
        System.out.println("testcommit");

	// write your code here
    }
}
