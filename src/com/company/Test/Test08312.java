package com.company.Test;

public class Test08312 {
    public static void main(String[] args){
        System.out.println(sum(100));
    }

    public static int sum(int i){
        if(i == 1){
            return 1;
        }
        return i + sum(i - 1);
    }
}
