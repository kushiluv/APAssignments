package com.company;
import java.util.Random;

public class Player {
    private int hop;
    private Random rand = new Random();
    void jump(){
        hop = 1+ rand.nextInt(19);
    }
    public int getHop(){
        return hop;
    }
}
