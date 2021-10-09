package com.company;

public class hospital {
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
