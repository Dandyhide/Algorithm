package com.company.DataStructure.Sort.Sort12_21;

public class BubbleSort {
    public void sort(int[] a){
        for (int i = 0; i < a.length - 1; i++){
            for (int j = 0; j < a.length - i - 1; j++){
                if (a[j] > a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
}
