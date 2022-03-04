package com.company.AllRange.Sort.Sort1;

public class SelectSort {
    public void sort(int[] a){
        for (int i = 0; i < a.length; i++){
            int min = i;
            for (int j = i + 1; j < a.length; j++){
                if (a[j] < a[min]){
                    min = j;
                }
            }
            if (min != i){
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,5,4};
        SelectSort sort = new SelectSort();
        sort.sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
