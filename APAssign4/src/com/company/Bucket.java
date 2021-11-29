package com.company;

import java.util.ArrayList;

public class Bucket {
    private ArrayList<Toys> toys = new ArrayList<Toys>();

    public void add_toy(Toys toy) {
        this.toys.add(toy);
    }
    public int get_size(){
        return toys.size();
    }
    public void print_collected_toys(){
        for(int i = 0; i < get_size();i++){
            System.out.println(toys.get(i).getName());
        }
    }
}


