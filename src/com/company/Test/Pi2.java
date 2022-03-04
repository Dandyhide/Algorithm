package com.company.Test;

import java.math.BigDecimal;

public class Pi2 {
//    public BigDecimal CalculatePI(int point){
//
//    }

    public static void main(String[] args) {
        BigDecimal m = BigDecimal.valueOf(1);
        BigDecimal n = BigDecimal.valueOf(3);
        System.out.println(m.divide(n).intValue());
    }
}
