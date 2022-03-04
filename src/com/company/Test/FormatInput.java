package com.company.Test;

public class FormatInput {
    public static void main(String[] args) {
        String s = "[[0,9],[4,1],[5,7],[6,2],[7,4],[10,9]]";
        s = s.replace("[", "{");
        s = s.replace(']', '}');
        System.out.println(s);
    }
}
