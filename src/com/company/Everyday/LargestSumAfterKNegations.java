package com.company.Everyday;

import java.util.Arrays;

public class LargestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            if (nums[i] < 0 && k > 0){
                nums[i] = - nums[i];
                k--;
            }else{
                break;
            }
        }
        Arrays.sort(nums);
        if (k > 0 && k % 2 != 0){
            nums[0] = -nums[0];
        }
        return Arrays.stream(nums).sum();
    }
}
