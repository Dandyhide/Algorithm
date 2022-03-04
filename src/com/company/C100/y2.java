package com.company.C100;

import java.util.Scanner;
import java.math.*;

public class y2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long value = sc.nextLong();
        int temp = 100000;
        if (value <= temp){
            System.out.println(value * 0.1);
        }else if (value > temp && value <= temp * 2){
            System.out.println(temp * 0.1 + (value - temp * 2) * 0.075);
        }else if (value > temp * 2 && value <= temp * 4){
            System.out.println(temp * 0.1 + 2 * temp * 0.075 + (value - temp * 4) * 0.05);
        }
        //........
    }
}
