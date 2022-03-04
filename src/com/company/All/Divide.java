package com.company.All;

public class Divide {
    public int divide(int dividend, int divisor) {
        if (dividend == -2147483648 && divisor == 1){
            return -2147483648;
        }
        if (dividend == -2147483648 && divisor == -1){
            return 2147483647;
        }
        boolean flag = true;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0){
            flag = false;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int res = 0;
        while (dividend >= divisor){
            dividend -= divisor;
            res++;
        }
        return flag ? res : -res;
    }
}
