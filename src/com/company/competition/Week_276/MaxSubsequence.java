package com.company.competition.Week_276;

import java.util.Arrays;

public class MaxSubsequence {
    public int[] maxSubsequence(int[] nums, int k) {
        int len = nums.length;
        int[] temp = new int[k];
        int[] nums_copy = new int[len];
        for (int i = 0; i < len; i++){
            nums_copy[i] = nums[i];
        }
        Arrays.sort(nums);
        for (int j = 0; j < k; j++){
            for (int i = 0; i < len; i++) {
                if (nums_copy[i] == nums[len - j - 1]){
                    temp[j] = i;
                    continue;
                }
            }
        }
        Arrays.sort(temp);
        int[] result = new int[k];
        for (int i = 0; i < k; i++){
            result[i] = nums_copy[temp[i]];
        }
        return result;
    }
}
