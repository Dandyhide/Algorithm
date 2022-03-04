package com.company.DataStructure.Sort.Sort12_21;

public class SelectSort {
    public void sort(int[] a){
        for (int i = 0; i < a.length - 1; i++){
            int min = i;
            for (int j = i + 1; j < a.length; j++){
                if (a[j] < a[min]){
                    min = j;
                }
            }
            if (i != min){
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }
}
