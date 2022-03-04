package com.company.All;

public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = -1, right = -1;
        int res = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 1){
                if (!flag){
                    left = i;
                    right = i;
                    flag = true;
                }else{
                    right = i;
                }
            }else{
                if (flag){
                    res = Math.max(res, right - left + 1);
                }
                flag = false;
            }
        }
        if (flag){
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
