package com.company.Test;

public class Fib {

    public int Fib(int k){
        int a = 1, b = 1;
        for (int i = 2; i < k; i++){
            if (i % 2 == 0){
                a = a + b;
            }else{
                b = a + b;
            }
        }
        return Math.max(a, b);
    }

}
