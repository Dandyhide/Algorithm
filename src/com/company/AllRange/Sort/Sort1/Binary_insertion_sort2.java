package com.company.AllRange.Sort.Sort1;

public class Binary_insertion_sort2 {
    public void sort(int[] a){
        for (int i = 1;i < a.length; i++){
            if (a[i] < a[i - 1]){
                int left = 0, right = i - 1;
                while (left <= right){
                    int mid = left + (right - left) / 2;
                    if (a[mid] > a[i]){
                        right = mid - 1;
                    }else {
                        left = mid + 1;
                    }
                }
                int temp = a[i];
                for (int j = i; j > left; j--){
                    a[j] = a[j - 1];
                }
                a[left] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,5,4, 4, 7, 8,2,3,1};
        Binary_insertion_sort2 sort = new Binary_insertion_sort2();
        sort.sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
