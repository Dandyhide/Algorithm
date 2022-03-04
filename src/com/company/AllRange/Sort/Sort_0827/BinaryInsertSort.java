package com.company.AllRange.Sort.Sort_0827;

public class BinaryInsertSort {
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
                //a[i]应该插入到right与left之间
                for (int j = i; j > left; j--){
                    a[j] = a[j - 1];
                }
                a[left] = temp;
            }
        }
    }
}
