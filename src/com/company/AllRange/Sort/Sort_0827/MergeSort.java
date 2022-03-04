package com.company.AllRange.Sort.Sort_0827;

public class MergeSort {
    public void sort(int[] a){
        int[] temp = new int[a.length];
        sort(a, 0, a.length - 1, temp);
    }

    public void sort(int[] a, int left, int right, int[] temp){
        if (left >= right){
            return;
        }
        int mid = left + (right - left) / 2;
        sort(a, left, mid, temp);
        sort(a, mid + 1, right, temp);
        merge(a, left, right, mid, temp);
    }

    private void merge(int[] a, int left, int right, int mid, int[] temp) {
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right){
            if (a[i] <= a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }
        while (i <= mid){
            temp[k++] = a[i++];
        }
        while (j <= right){
            temp[k++] = a[j++];
        }
        int t = 0;
        while (left <= right){
            a[left++] = temp[t++];
        }
    }
}
