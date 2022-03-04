package com.company.Test;

import java.util.Scanner;

public class test100IN {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] res = new int[100];
        for(int i = 0; i < 3; i++){
            String temp = sc.next();
            res[i] = getInt(temp);
            System.out.println(res[i]);
        }
        sc.close();
    }

    public static int getInt(String s){
        int sum = 0;
        char[] c = s.toCharArray();
        for(int i = 0; i < c.length; i++){
            sum += Integer.valueOf(c[i]);
        }
        return sum;
    }
}
