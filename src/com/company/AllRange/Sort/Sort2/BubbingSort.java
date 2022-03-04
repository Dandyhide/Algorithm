package com.company.AllRange.Sort.Sort2;

import com.company.AllRange.Sort.Sort1.BubbleSort;

public class BubbingSort {
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

    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,5,4};
        BubbleSort sort = new BubbleSort();
        sort.sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
