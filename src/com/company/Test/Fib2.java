package com.company.Test;

public class Fib2 {
    public int Fib(int k){
        if (k == 1 || k == 2){
            return 1;
        }
        return Fib(k - 1) + Fib(k - 2);
    }

    public static void main(String[] args) {
        Fib fib = new Fib();
        System.out.println(fib.Fib(30));
    }
}
