package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        Player player = new Player();
        int j = 0;

        ArrayList<Tile> tiles = new ArrayList<>();
        String[] toy_names = {"Fuzzy", "Softy", "Baby Bear", "Snugglebug", "Fuzzy Bear", "Cuddles", "Fuzzball", "Bobo", "Baba", "Snuggles", "Honey", "Honeypot", "Bubsy", "Winnie", "Tubby", "Pebbles", "Twinky", "Boo Boo", "Peaches", "Mr. Cuddles"};
        for (int i = 1; i <= 20; i++) {
            Tile temp = new Tile(toy_names[i - 1], i);
            tiles.add(temp);
        }
        Carpet carpet = new Carpet(tiles);
        Bucket bucket = new Bucket();
        while (j < 5) {
            if(j==0){
                System.out.println("Hit enter for your first hop");
                scan1.nextLine();
            }
            else if(j==2){
                System.out.println("Hit enter for your third hop");
                scan1.nextLine();
            }
            else if(j==3){
                System.out.println("Hit enter for your fourth hop");
                scan1.nextLine();
            }
            else if(j==1){
                System.out.println("Hit enter for your second hop");
                scan1.nextLine();
            }
            else{
                    System.out.println("Hit enter for your fifth hop");
                    scan1.nextLine();

            }
            player.jump();
            if(player.getHop()<=20){
                System.out.println("You landed on tile "+player.getHop());
            }
            else{
                System.out.println("You are too energetic and zoomed past all the tiles. Muddy Puddle Splash!");
                continue;
            }
            if (player.getHop() % 2 == 0) {
                Toys toy_clone = Carpet.get(player.getHop()).getToy().clone();
                bucket.add_toy(toy_clone);
//                System.out.println(bucket_.getName());
            }
            j++;
        }
        bucket.print_collected_toys();
    }
}
