package com.company;

public class vaccine {
    String name;
    int doses_num;
    int doses_gap;
    public vaccine(String name, int doses_num){
        this.name = name;
        this.doses_num = doses_num;
    }
    public String getName() {
        return name;
    }
    public int getDoses_num() {
        return doses_num;
    }
    public void setDoses_gap(int doses_gap){
        this.doses_gap=doses_gap;

    }
}
