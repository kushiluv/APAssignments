package com.company;

import java.util.ArrayList;

public class Carpet {
    private static ArrayList<Tile> tiles;

    public Carpet(ArrayList<Tile> tiles){
        this.tiles = tiles;
    }

    public static ArrayList<Tile> getTiles() {
        return tiles;
    }
    public static Tile get(int i){
        return tiles.get(i);
    }
}
