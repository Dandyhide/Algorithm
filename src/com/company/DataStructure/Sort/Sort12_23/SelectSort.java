package com.company.DataStructure.Sort.Sort12_23;

public class SelectSort {
    public void sort(int[] a){
        for (int i = 0; i < a.length; i++){
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
