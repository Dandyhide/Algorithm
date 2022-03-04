package com.company.AllRange.Sort.Sort0830;

public class Test {
    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,5,4};
        HeapSort sort = new HeapSort();
        sort.sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
