package com.company.AllRange.Sort.Sort2;

import com.company.AllRange.Sort.Sort1.BubbleSort;

public class InsertSort {
    public void sort(int[] a){
        for (int i = 1; i < a.length; i++){
            if (a[i] < a[i - 1]){
                int temp = a[i];
                int j = i;
                while (j >= 0 && a[j - 1] > temp){
                    a[j] = a[j - 1];
                    j--;
                }
                a[j + 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,5,4};
        BubbleSort sort = new BubbleSort();
        sort.sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
