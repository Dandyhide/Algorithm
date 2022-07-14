package com.company.competition.Week_284;

import java.util.Arrays;

public class MaximumTop {
    public int maximumTop(int[] nums, int k) {
        if(k == 0){
            return nums[0];
        }
        if (nums.length == 1){
            return k % 2 == 0 ? nums[0] : -1;
        }
        if (k == 1){
            return nums[1];
        }
        if(k > nums.length){
            Arrays.sort(nums);
            return nums[nums.length - 1];
        }
        int max = -1;
        for (int i = 0; i < nums.length && i < k - 1; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        return Math.max(max, k < nums.length ? nums[k] : 0);
    }
}
