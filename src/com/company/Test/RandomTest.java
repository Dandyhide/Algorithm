package com.company.Test;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random();
        int sum = 0;
        double total = 1000;
        for (int i = 0; i < total; i++) {
            int j = random.nextInt(2);
            sum += j;
        }
        double res = total / 2 - sum;
        System.out.println(res);
        double ratio = Math.abs(res) / total;
        System.out.println(ratio);
    }
}
