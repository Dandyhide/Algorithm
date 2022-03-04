package com.company.Test;

import com.sun.org.apache.bcel.internal.generic.GOTO;

public class TestGOTO {

    public static void main(String[] args) {
        String temp = "GOTO";
        CheckTarget:
        for (;;){
                if (false){
                    System.out.println(123);
                }else{
                    System.out.println(000);
                    continue CheckTarget;
                }
                return;
        }
    }

}
