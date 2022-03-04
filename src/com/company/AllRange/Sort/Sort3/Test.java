package com.company.AllRange.Sort.Sort3;

public class Test {
    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,5,4};
        MergeSort sort = new MergeSort();
        sort.sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
