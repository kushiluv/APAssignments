package com.company;

public class Calculator <T> {

    public <T> T calculate(T a, T b) {
        if (a instanceof Integer) {
            return (T) (Integer) Math.floorDiv((int) a, (int) b);
        } else {
            return (T) (a.toString() + b.toString());
        }


    }
}
