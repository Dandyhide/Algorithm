package com.company.AllRange.Sort.Sort2;

import java.util.Arrays;

public class HeapSort2 {
    public void sort(int[] a){
        for (int i = a.length / 2 - 1; i >= 0; i--){
            adjustHeap(a, i, a.length);
        }
        for (int i = a.length - 1; i > 0; i--){
            int temp = a[i];
            a[i] = a[0];
            a[0] = a[i];
            adjustHeap(a, i, a.length);
        }
    }

    public void adjustHeap(int[] a, int i, int length){
        int temp = a[i];
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1){
            if (k + 1 < length && a[k] < a[k + 1]){
                k = k + 1;
            }
            if (a[k] > a[i]){
                a[i] = a[k];
                i = k;
            }else{
                break;
            }
        }
        a[i] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,5,4};
        HeapSort sort = new HeapSort();
        sort.sort(a);
//        for (int i : a) {
//            System.out.println(i);
//        }
        System.out.println(Arrays.toString(a));
    }
}
