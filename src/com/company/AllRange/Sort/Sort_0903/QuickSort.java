package com.company.AllRange.Sort.Sort_0903;

public class QuickSort {
    public void sort(int[] a, int left, int right){
        if (left >= right){
            return;
        }
        int i = left, j = right, temp = a[left];
        while (i < j){
            while (i < j && a[j] >= temp){
                j--;
            }
            if (i < j){
                a[i] = a[j];
            }
            while (i < j && a[i] <= temp){
                i++;
            }
            if (i < j){
                a[j] = a[i];
            }
        }
        a[i] = temp;
        sort(a, left, i - 1);
        sort(a, i + 1, right);
    }
}
