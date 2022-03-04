package com.company.AllRange.Sort.Sort2;

import com.company.AllRange.Sort.Sort1.BubbleSort;

public class Binary_insert_sort {
    public void sort(int[] a){
        for (int i = 1; i < a.length; i++){
            if (a[i] < a[i - 1]){
                int left = 0, right = i - 1;
                int temp = a[i];
                while (left <= right){
                    int mid = left + (right - left) / 2;
                    if (a[mid] > temp){
                        right = mid - 1;
                    }else{
                        left = mid + 1;
                    }
                }
                for (int j = i - 1; j > right; j--){
                    a[j + 1] = a[j];
                }
                a[right + 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,5,4};
        Binary_insert_sort sort = new Binary_insert_sort();
        sort.sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
