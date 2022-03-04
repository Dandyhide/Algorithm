package com.company.Study.DesignDataStructure;

public class FindMaximumXOR {
    public int findMaximumXOR(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                res = Math.max(res, nums[i]^nums[j]);
            }
        }
        return res;
    }
}
