package com.company.C100;

import java.util.Scanner;

public class TotalSeven {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();
        int min = a < b ? a : b;
        int total = 0;
        for (int i = min; i <= (a + b) - min; i++){
            if (i / 1000 + (i / 100) % 10 + (i / 10) % 10 + i % 10 == 7){
                total++;
            }
        }
        System.out.println(total);
    }
}
