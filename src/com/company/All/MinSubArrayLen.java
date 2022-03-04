package com.company.All;

import java.util.Arrays;

public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int min = len + 1;
        int[] sum = new int[len + 1];
        sum[1] = nums[0];
        for (int i = 2; i < len + 1; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        if (target > sum[len]){
            return 0;
        }
        for (int i = 1; i < len + 1; i++){
            //二分查找
            if (sum[i] >= target){
                int bound = sum[i] - target;
                int left = 0, right = i;
                boolean flag = false;
                while (left <= right){
                    int mid = (left + right) / 2;
                    if (sum[mid] < bound){
                        left = mid + 1;
                    }else if (sum[mid] > bound){
                        right = mid - 1;
                    }else{
                        min = Math.min(min, i - mid);
                        flag = true;
                        break;
                    }
                }
                if (!flag){
                    min = Math.min(min, i - left + 1);
                }
            }
        }
        return min;
    }
}
