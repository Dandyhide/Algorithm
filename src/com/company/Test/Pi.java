package com.company.Test;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Random
 */

public class Pi {
    public double CalculatePI(int point){
        Random random = new Random(1);
        double sum = 1;
        for (int i = 0; i < point; i++){
            sum = sum * 10;
        }
        int count = 0;
        double m = 0, n = 0;
        for (int i = 0; i < sum; i++){
            m = random.nextDouble();
            n = random.nextDouble();
            if (m * m + n * n < 1){
                count++;
            }
        }
        return (count / sum) * 4;
    }

    public static void main(String[] args) {
        Pi pi = new Pi();
        System.out.println(pi.CalculatePI(8));
    }
}
