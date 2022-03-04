package com.company.Test;

import java.util.Scanner;

public class ScannerTest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] src = new String[100];
        int[] res = new int[100];
        for (int i = 0; i < 5; i++){
            String s = scanner.next();
            src[i] = s;
        }
        scanner.close();
        for (int i = 0; i < 100; i++){
            char[] chars = src[i].toCharArray();
            int sum = 0;
            for (int j = 0; j < chars.length; j++){
                sum += Integer.valueOf(chars[j]);
            }
            res[i] = sum;
            System.out.println(src[i] + " : " + sum);
        }
    }
}
