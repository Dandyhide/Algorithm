package com.company.AllRange.Sort.Sort0830;

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

    private void adjustHeap(int[] a, int i, int length) {
        int temp = a[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1){
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
}
