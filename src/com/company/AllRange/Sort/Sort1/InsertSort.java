package com.company.AllRange.Sort.Sort1;

public class InsertSort {
    public void sort(int[] a){
        for (int i = 1; i < a.length; i++){
            if (a[i] < a[i - 1]){
                int temp = a[i];
                int k = i - 1;
                while (k >= 0 && a[k] > temp){
                    a[k + 1] = a[k];
                    k--;
                }
                a[k + 1] = temp;
            }
        }
        System.out.println(a);
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,5,4};
        InsertSort sort = new InsertSort();
        sort.sort(a);
    }
}
