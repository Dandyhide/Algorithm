package com.company.AllRange.Sort.Sort1;

public class Binary_insertion_sort {
    public void sort(int[] a){
        for (int i = 1; i < a.length; i++){
            int left = 0, right = i - 1;
            while (left <= right){
                int mid = left + (right - left) / 2;
                if (a[mid] > a[i]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            int temp = a[i];
            int j;
            for (j = i - 1; j >= right + 1; j--){
                a[j + 1] = a[j];
            }
            a[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,5,4, 4, 7, 8,2,3,1};
        Binary_insertion_sort sort = new Binary_insertion_sort();
        sort.sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
