package com.company.AllRange.Sort.Sort_0831_ok1;

public class HeapSort {
    public void sort(int[] a){
        for (int i = a.length / 2 - 1; i >= 0; i--){
            adjustHeap(a, i, a.length);
        }
        for (int i = a.length - 1; i > 0; i--){
            int temp = a[i];
            a[i] = a[0];
            a[0] = temp;
            adjustHeap(a, 0, i);
        }
    }

    public void adjustHeap(int[] a, int k, int length){
        int temp = a[k];
        for (int i = k * 2 + 1; i < length; i = i * 2 + 1){
            if (i + 1 < length && a[i] < a[i + 1]){
                i = i + 1;
            }
            if (a[i] > a[k]){
                a[k] = a[i];
                k = i;
            }else{
                break;
            }
        }
        a[k] = temp;
    }
}
