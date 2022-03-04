package com.company.AllRange.Sort.Sort2;

public class ShellSort {
    public void sort(int[] a){
        for (int gap = a.length / 2; gap > 0; gap = gap / 2){
            for (int j = gap; j < a.length; j++){
                if (a[j] < a[j - gap]){
                    int temp = a[j];
                    int k = j;
                    while (k - gap >= 0 && a[k - gap] > temp){
                        a[k] = a[k - gap];
                        k = k - gap;
                    }
                    a[k] = temp;
                }
            }
        }
    }

    public void sort2(int[] a){
        for (int gap = a.length / 2; gap > 0; gap = gap / 2){
            for (int i = gap; i < a.length; i++){
                if (a[i] < a[i - gap]){
                    int j = i;
                    int temp = a[i];
                    while (j - gap >= 0 && a[j - gap] > temp){
                        a[j] = a[j - gap];
                        j = j - gap;
                    }
                    a[j] = temp;
                }
            }
        }
    }

    public void sort3(int[] a){
        for (int gap = a.length / 2; gap > 0; gap = gap / 2){
            for (int i = gap; i < a.length; i++){
                if (a[i] < a[i - gap]){
                    int j = i;
                    while (j - gap >= 0 && a[j] < a[j - gap]){
                        int temp = a[j];
                        a[j] = a[j - gap];
                        a[j - gap] = temp;
                        j = j - gap;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,5,4};
        ShellSort sort = new ShellSort();
        sort.sort3(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
