package com.company.AllRange.Sort.Sort_0903;

public class ShellSort {
    public void sort(int[] a){
        for (int gap = a.length / 2; gap > 0; gap--){
            for (int i = gap; i < a.length; i++){
                if (a[i] < a[i - gap]){
                    int temp = a[i];
                    int j = i - gap;
                    while (j >= 0 && a[j] > temp){
                        a[j + gap] = a[j];
                        j = j - gap;
                    }
                    a[j + gap] = temp;
                }
            }
        }
    }
}
