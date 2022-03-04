package com.company.AllRange.Sort.Sort3;

public class Binary_insert_sort {
    public void sort(int[] a){
        for (int i = 1; i < a.length; i++){
            if (a[i] < a[i - 1]){
                int left = 0, right = i - 1;
                int temp = a[i];
                while (left <= right){
                    int mid = left + (right - left) / 2;
                    if (a[mid] <= temp){
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                }
                //此时left = right + 1，插入位置为right与left之间
                for (int j = i; j > left; j--){
                    a[j] = a[j - 1];
                }
                a[left] = temp;
            }
        }
    }
}
