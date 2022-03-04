package com.company.AllRange.Sort.Sort1;

public class ShellSort {
    public void sort(int[] a){
        for (int gap = a.length / 2; gap > 0; gap = gap / 2){
            for (int i = gap; i < a.length; i++){
                int j = i;
                while (j - gap >= 0 && a[j - gap] > a[j]){
                    int temp = a[j - gap];
                    a[j - gap] = a[j];
                    a[j] = temp;
                    j = j - gap;
                }
            }
        }
    }

    public void sort1(int[] a){
        for (int gap = a.length / 2; gap > 0; gap = gap / 2){
            for (int i = gap; i < a.length; i++){
                int j = i;
                int temp = a[j];
                while (j - gap >= 0 && a[j - gap] > temp){
                    a[j] = a[j - gap];
                    j = j - gap;
                }
                a[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,5,4};
        ShellSort sort = new ShellSort();
        sort.sort1(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
