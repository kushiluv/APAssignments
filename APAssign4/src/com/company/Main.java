package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        Player player = new Player();
        Random rand = new Random();
        String type;
        int rand1,rand2,flag;
        String random,random1 ;
        int j = 0;

        ArrayList<Tile> tiles = new ArrayList<>();
        String[] toy_names = {"Fuzzy", "Softy", "Baby Bear", "Snugglebug", "Fuzzy Bear", "Cuddles", "Fuzzball", "Bobo", "Baba", "Snuggles", "Honey", "Honeypot", "Bubsy", "Winnie", "Tubby", "Pebbles", "Twinky", "Boo Boo", "Peaches", "Mr. Cuddles"};
        for (int i = 1; i <= 20; i++) {
            Tile temp = new Tile(toy_names[i - 1], i);
            tiles.add(temp);
        }
        Carpet carpet = new Carpet(tiles);
        Bucket bucket = new Bucket();

        while(true) {
            try {
                System.out.println("Hit enter to initialize the game");
                String temps = scan2.nextLine();
                if (!(temps.equals("")) ) {
                    throw new InputMismatchException("Invalid input");
                }
                else{
                    System.out.println("Game is ready");
                    break;
                }

            } catch (InputMismatchException nts) {
                System.out.println(nts);
            }
        }
        while (j < 5) {
            if(j==0){
                System.out.println("Hit enter for your first hop");
            }
            else if(j==2){
                System.out.println("Hit enter for your third hop");
            }
            else if(j==3){
                System.out.println("Hit enter for your fourth hop");
            }
            else if(j==1){
                System.out.println("Hit enter for your second hop");
            }
            else{
                    System.out.println("Hit enter for your fifth hop");

            }
            while(true) {
                try {
                    String temps1 = scan2.nextLine();
                    if (!(temps1.equals("") )) {
                        throw new InputMismatchException("Invalid input");
                    }
                    break;
                } catch (InputMismatchException nts) {
                    System.out.println(nts);
                }
            }

            player.jump();
            flag=0;

                try {
                     Carpet.getTiles().get(player.getHop());
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("You are too energetic and zoomed past all the tiles. Muddy Puddle Splash!");
                    flag=1;
                }

            if(flag==1){
                j++;
                continue;
            }
            int tile_no = carpet.get(player.getHop()).getTile_no()+1;
            System.out.println("You landed on tile "+tile_no);
            if (player.getHop() % 2 == 0) {
                Toys toy_clone = Carpet.get(player.getHop()).cloneToy();
                bucket.add_toy(toy_clone);
                System.out.println("You won a "+toy_clone.getName()+" soft toy.");
            }
            else{
                System.out.println("Question answer round. Integer or strings?");
                String typeq;
                while(true) {
                    try {
                        typeq = scan2.next();
                        if (!(typeq.equals("integer") || typeq.equals("string"))) {
                            throw new InputMismatchException("Enter integer or string as the input");
                        }
                        break;
                    } catch (InputMismatchException nts) {
                        System.out.println(nts);
                    }
                }
                if(typeq.equals("integer")) {
                    rand1 = (rand.nextInt());
                    rand2 = (rand.nextInt());

                    if(rand2==0){
                        rand2++;
                    }

                    System.out.println("Calculate the result of " + rand1 + " divided by " + rand2);
                    int sol ;

                    while(true){
                        try{
                            sol = scan2.nextInt();
                            scan2.nextLine();
                            break;
                        }
                        catch(InputMismatchException e){
                            System.out.println("Wrong input , try again");
                            scan2.nextLine();

                        }
                    }
                    Calculator<Integer> calculator = new Calculator<Integer>();
                    int calcu = calculator.calculate(rand1, rand2);
                    if (sol == calcu) {
                        System.out.println("Correct answer");
                        Toys toy_clone = Carpet.get(player.getHop()).cloneToy();
                        bucket.add_toy(toy_clone);
                        System.out.println("You won a " + toy_clone.getName() + " soft toy.");
                    } else {
                        System.out.println("Incorrect answer");
                        System.out.println("You didn't win any soft toy");

                    }
                }
                else if(typeq.equals("string")){
                        String total = "abcde" +
                                "\fghijklmnopqrstvuwxyzABCDEFGHIJKLMNOPQRSTVUWXYZ0123456789";
                        random ="";
                        random1 = "";
                        for(int i = 0 ; i<4 ; i++){
                            rand1 = rand.nextInt(62);
                            rand2 = rand.nextInt(62);
                            random+=(total.charAt(rand1));
                            random1+=(total.charAt(rand2));
                        }
                        System.out.println("Calculate the concatenation of strings "+random+" and "+random1);
                        String ans = scan2.next();
                        Calculator<String> calculator= new Calculator<String>();
                        String calcu = calculator.calculate(random,random1);
                        if(ans.equals(calcu)){
                            System.out.println("Correct answer");
                            Toys toy_clone = Carpet.get(player.getHop()).cloneToy();
                            bucket.add_toy(toy_clone);
                            System.out.println("You won a "+toy_clone.getName()+" soft toy.");
                        }
                        else{
                            System.out.println("Incorrect answer");
                            System.out.println("You didn't win any soft toy");
                        }
                }
            }
            j++;
        }
        System.out.println("Game Over");
        System.out.println("\nSoft toys won by you are:");
        bucket.print_collected_toys();
    }
}
