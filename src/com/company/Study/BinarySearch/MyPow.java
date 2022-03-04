package com.company.Study.BinarySearch;

public class MyPow {
    public double myPow(double x, int n) {
        return n >= 0 ? quickMul(x, n) : 1 / quickMul(x, -n);
    }

    private double quickMul(double x, int n) {
        if (n == 0){
            return 1.0;
        }
        double res = quickMul(x * x, n / 2);
        return n % 2 == 0 ? res : res * x;
    }
}
