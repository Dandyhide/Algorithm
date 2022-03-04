package com.company.AllRange.Sort.Sort2;

import com.company.AllRange.Sort.Sort1.BubbleSort;

public class QuickSort {
    public void sort(int[] a, int left, int right){
        if (left >= right){
            return;
        }
        int i = left, j = right, temp = a[left];
        while (i < j){
            while (i < j && a[j] > temp){
                j--;
            }
            if (i < j){
                a[i] = a[j];
            }
            while (i < j && a[i] < temp){
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

    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,5,4};
        QuickSort sort = new QuickSort();
        sort.sort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
