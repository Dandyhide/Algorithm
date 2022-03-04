package com.company.Test;

import java.math.BigDecimal;

public class Factorial {
    public BigDecimal getFactorial(int n){
        BigDecimal result = BigDecimal.ONE;
        for (int i = 1; i < n; i++){
            result = result.multiply(BigDecimal.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        BigDecimal result = factorial.getFactorial(10000);
        System.out.println(result);
    }
}
