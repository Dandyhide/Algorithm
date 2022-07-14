package com.company;

public class FormatInput {
    public static void main(String[] args) {
        String s = "[[1,1,1],[1,0,1],[1,1,1]]";
        s = s.replace("[", "{");
        s = s.replace(']', '}');
        System.out.println(s);
    }
}
