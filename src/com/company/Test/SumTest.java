package com.company.Test;

public class SumTest {
    public static void main(String[] args) {
        System.out.println(sum(100));
    }
    public static int sum(int n){
        if (n > 0){
            return n + sum(n - 1);
        }
        return 0;
    }
}
