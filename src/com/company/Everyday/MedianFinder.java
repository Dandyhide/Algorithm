package com.company.Everyday;

/**
 * 295. 数据流的中位数     Difficult
 *
 *  超时
 */

public class MedianFinder {

    int left;
    int right;
    int[] res;
    int count;

    /** initialize your data structure here. */
    public MedianFinder() {
        res = new int[10000];
        count = 0;
        left = right = -1;
    }

    public void addNum(int num) {
        insert(res, num);
        count++;
        left = (count - 1) / 2;
        right = count / 2;
    }

    public double findMedian() {
        double num = res[left] + res[right];
        return num / 2;
    }

    private void insert(int[] res, int num) {
        if (count == 0){
            res[0] = num;
        }else{
            if (res[count - 1] <= num){
                res[count] = num;
            }else{
                int left = 0, right = count - 1;
                while (left <= right){
                    int mid = left + (right - left) / 2;
                    if (res[mid] > num){
                        right = mid - 1;
                    }else{
                        left = mid + 1;
                    }
                }
                for (int j = count; j > left; j--){
                    res[j] = res[j - 1];
                }
                res[left] = num;
            }

        }
    }
}
