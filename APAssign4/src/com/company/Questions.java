package com.company;

import java.util.Random;
import java.util.Scanner;

public class Questions <T> extends Calculator{
    private T temp;
    private String type;
    private int rand1,rand2;
    private StringBuilder random,random1 = new StringBuilder();
    public Questions(){
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        if(temp instanceof Integer){
            rand1 = rand.nextInt();
            rand2 = rand.nextInt();
            System.out.println("Calculate the result of "+rand1+" divided by "+rand2);
            int ans = scan.nextInt();
            boolean temp = integer_calculator(rand1,rand2,ans);
        }
        else{
            String total = "abcdefghijklmnopqrstvuwxyzABCDEFGHIJKLMNOPQRSTVUWXYZ0123456789";
            for(int i = 0 ; i<4 ; i++){
                rand1 = rand.nextInt(62);
                rand2 = rand.nextInt(62);
                random.append(total.charAt(rand1));
                random1.append(total.charAt(rand2));
            }
            System.out.println("Calculate the concatenation of strings "+random+" and "+random1);
//            StringBuilder ans = scan.next();
//            boolean temp = String_calculator(random,random1)
        }
    }

}
