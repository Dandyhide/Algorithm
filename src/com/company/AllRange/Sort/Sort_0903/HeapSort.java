package com.company.AllRange.Sort.Sort_0903;

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

    public void adjustHeap(int[] a, int i, int len){
        int temp = a[i];
        for (int k = i * 2 + 1; k < len; k = k * 2 + 1){
            if (k + 1 < len && a[k] < a[k + 1]){
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
}
