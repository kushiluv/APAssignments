package com.company;

public class Toys implements Cloneable{
    private String name;

    public Toys(String name ){
        this.name = name;

    }
    public String getName(){
        return name;
    }

    @Override
    public Toys clone(){

        try{
            Toys clone = (Toys)super.clone();
            return clone;
        }
        catch(CloneNotSupportedException cse){
            return null;
        }
    }
}
