package com.company.AllRange.Sort.Sort_0827;


import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,5,4};
        BinaryInsertSort sort = new BinaryInsertSort();
        sort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
