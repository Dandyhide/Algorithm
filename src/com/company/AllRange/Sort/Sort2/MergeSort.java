package com.company.AllRange.Sort.Sort2;

import java.util.Arrays;

public class MergeSort {
    public void sort(int[] a){
        int[] temp = new int[a.length];
        sort(a, 0, a.length - 1, temp);
    }

    public void sort(int[] a, int left, int right, int[] temp){
        if (left < right){
            int mid = left + (right - left) / 2;
            sort(a, left, mid, temp);
            sort(a, mid + 1, right, temp);
            merge(a, left, right, mid, temp);
        }
    }

    public void merge(int[] a, int left, int right, int mid, int[] temp){
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right){
            if (a[i] <= a[j]){
                temp[t++] = a[i++];
            }else{
                temp[t++] = a[j++];
            }
        }
        while (i <= mid){
            temp[t++] = a[i++];
        }
        while (j <= right){
            temp[t++] = a[j++];
        }
        t = 0;
        for (int k = left; k <= right; k++){
            a[k] = temp[t++];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,5,4};
        MergeSort sort = new MergeSort();
        sort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
