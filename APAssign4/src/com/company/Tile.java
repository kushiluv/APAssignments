package com.company;

public class Tile {
    private Toys toy ;
    private int tile_no;
    private Toys toy_clone;
    public Tile(String name,int tile_no){
        toy = new Toys(name);
        this.tile_no = tile_no;
    }
    public Toys getToy() {
        return toy;
    }
    public Toys cloneToy(){
        toy_clone = toy.clone();
        return toy_clone;
    }
    public int getTile_no(){
        return tile_no;
    }

}
