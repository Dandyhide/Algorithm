package com.company.Test;

public class TryCatch {
    public static void main(String[] args) {
        System.out.println("result: " + TryCatch.check());
    }

    public static int check(){
        int a = 0;
        try {
            a = 1;
            System.out.println(a);
            return a;
        }catch (Exception e){
            a = 2;
            System.out.println(a);
            return a;
        }finally {
            try {
                a = 3 / 0;
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(a);
        }
    }
}
