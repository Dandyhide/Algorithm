package com.company.AllRange.Sort.Sort_0827;

public class ShellSort {
    public void sort(int[] a){
        for (int gap = a.length / 2; gap > 0; gap = gap / 2){
            for (int i = gap; i < a.length; i++){
                if (a[i] < a[i - gap]){
                    int temp = a[i];
                    int j = i;
                    while (j - gap >= 0 && a[j - gap] > temp){
                        a[j] = a[j - gap];
                        j = j - gap;
                    }
                    a[j] = temp;
                }
            }
        }
    }
}
