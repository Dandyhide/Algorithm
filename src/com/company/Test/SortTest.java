package com.company.Test;

public class SortTest {
    public void BubbleSort(int[] a){
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a.length - i - 1; j++){
                if (a[j] > a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = a[j];
                }
            }
        }
    }

    public void SelectSort(int[] a){
        for (int i = 0; i < a.length - 1; i++){
            int min = i;
            for (int j = i + 1; j < a.length; j++){
                if (a[min] > a[j]){
                    min = j;
                }
            }
            if (min != i){
                //交换
            }
        }
    }

    public void InsertSort(int[] a){
        for (int i = 1; i < a.length; i++){
            int temp = a[i];
            if (a[i - 1] > temp){
                int j = i - 1;
                while (a[j] > temp){
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = temp;
            }
        }
    }

    public void QuickSort(int[] a, int left, int right){
        int temp = a[left], i = left, j = right;
        while (i < j){
            while (i < j && a[j] > temp){
                j--;
            }
            if (i < j){
                a[i] = a[j];
            }
            while (i < j && a[i] < temp){
                i++;
            }
            if (i < j){
                a[j] = a[i];
            }
        }
        a[i] = temp;
        QuickSort(a, left, i - 1);
        QuickSort(a, i + 1, right);
    }

    public void ShellSort(int[] a){
        for (int step = a.length / 2; step > 0; step = step / 2){
            for (int i = step; i < a.length; i++){
                int j = i;
                int temp = a[j];
                while (j - step >= 0 && a[j - step] > temp){
                    a[j] = a[j - step];
                    j = j - step;
                }
                a[j] = temp;
            }
        }
    }

    public void ShellSort2(int[] a){
        for (int gap = a.length / 2; gap > 0; gap = gap / 2){
            for (int i = gap; i < a.length; i++){
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

    public void BinarySort(int[] a){
        for (int i = 1; i < a.length; i++){
            if (a[i] < a[i - 1]){
                int l = 0, r = i - 1;
                while (l <= r){
                    int mid = l + (r - l) / 2;
                    if (a[mid] > a[i]){
                        r = mid - 1;
                    }else {
                        l = mid + 1;
                    }
                }
                int temp = a[i];
                for (int j = i; j > l; j--){
                    a[j] = a[j - 1];
                }
                a[l] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,5,4, 4, 7, 8,2,3,1};
        SortTest sort = new SortTest();
        sort.BinarySort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
