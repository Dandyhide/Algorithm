package com.company.AllRange.Sort.Sort0830;

public class MergeSort {
    public void sort(int[] a){
        int temp[] = new int[a.length];
        sort(a, 0, a.length - 1, temp);
    }

    private void sort(int[] a, int l, int r, int[] temp) {
        if (l >= r){
            return;
        }
        int mid = l + (r - l) / 2;
        sort(a, l, mid, temp);
        sort(a, mid + 1, r, temp);
        merge(a, l, r, mid, temp);
    }

    private void merge(int[] a, int l, int r, int mid, int[] temp) {
        int i = l;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= r){
            if (a[i] <= a[j]){
                temp[t++] = a[i++];
            }else{
                temp[t++] = a[j++];
            }
        }
        while (i <= mid){
            temp[t++] = a[i++];
        }
        while (j <= r){
            temp[t++] = a[j++];
        }
        int k = 0;
        while (l <= r){
            a[l++] = temp[k++];
        }
    }
}
