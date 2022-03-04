package com.company.DataStructure.Sort.Sort12_23;

public class BinaryInsertSort {
    public void sort(int[] a){
        for (int i = 1; i < a.length; i++){
            if (a[i] < a[i - 1]){
                int left = 0, right = i - 1, temp = a[i];
                while (left <= right){
                    int mid = left + (right - left) / 2;
                    if (a[mid] > temp){
                        right = mid - 1;
                    }else{
                        left = mid + 1;
                    }
                }
                //此时left = right + 1;插入位置为left与right之间
                int j = i;
                while (j > left){
                    a[j] = a[j - 1];
                    j--;
                }
                a[left] = temp;
            }
        }
    }
}
