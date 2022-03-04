package com.company.AllRange.Sort.Sort_0831_ok1;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,5,4};
        QuickSort sort = new QuickSort();
        sort.sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
