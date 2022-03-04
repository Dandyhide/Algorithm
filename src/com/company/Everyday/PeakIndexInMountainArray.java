package com.company.Everyday;

public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right - 1){
            int mid = (left +right) >> 1;
            if (arr[mid] > arr[mid - 1]){
                left = mid;
            }else if (arr[mid] < arr[mid - 1]){
                right = mid;
            }
        }
        return left;
    }
}
