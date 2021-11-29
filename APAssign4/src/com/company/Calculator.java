package com.company;

public class Calculator {
    private int ans;
    private String ans1;
    public boolean integer_calculator(int a, int b,int result){
        ans = Math.floorDiv(a,b);
        return (result==ans);
    }
    public boolean String_calculator(StringBuilder a, StringBuilder b , String result){
//        ans1 = a + b;
        return (ans1.equals(result));
    }

}
