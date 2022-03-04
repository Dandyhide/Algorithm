package com.company.Test;

import java.util.Scanner;

public class Test0831 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 20; i++){
            double max = 0.0;
            for(int j = 0; j < 5; j++){
                double  temp = sc.nextDouble();
                if (temp > max){
                    max = temp;
                }
            }
            System.out.println(max);
        }
        sc.close();
    }
}
