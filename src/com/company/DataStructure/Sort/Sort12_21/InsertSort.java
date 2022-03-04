package com.company.DataStructure.Sort.Sort12_21;

public class InsertSort {
    public void sort(int[] a){
        for (int i = 1; i < a.length; i++){
            if (a[i] < a[i - 1]){
                int j = i - 1;
                int temp = a[i];
                while (j >= 0 && a[j] > temp){
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] =temp;
            }
        }
    }
}
