package com.company.Test;

import java.util.Scanner;

public class ScannerTest1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String next = input.next();
        System.out.println(next);
        next.toCharArray();
        int num = input.nextInt();
        switch (num) {
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
            default:
                System.out.println("error");
                break;
        }
    }
}
