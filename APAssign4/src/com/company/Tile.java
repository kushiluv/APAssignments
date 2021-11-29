package com.company;

public class Tile {
    private Toys toy ;
    private int tile_no;
    public Tile(String name,int tile_no){
        toy = new Toys(name);
        this.tile_no = tile_no;
    }
    public Toys getToy() {
        return toy;
    }
    public int getTile_no(){
        return tile_no;
    }

}
