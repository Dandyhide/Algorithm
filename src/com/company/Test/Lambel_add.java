package com.company.Test;

public class Lambel_add {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5};
        int[] b = new int[]{6,7,8,9,10};
        class add_test{
            public int add(int i, int j){
                return a[i] + b[j];
            }
        }
        add_test add_test = new add_test();
        System.out.println( add_test.add(0, 0));
    }
}
