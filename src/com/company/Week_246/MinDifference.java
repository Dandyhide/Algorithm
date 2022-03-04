package com.company.Week_246;

import java.util.Arrays;

public class MinDifference {
    public int[] minDifference(int[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++){
            res[i] = GetMinAbs(nums, queries[i][0], queries[i][1]);
        }
        return res;
    }

    private int GetMinAbs(int[] nums, int i, int j) {
        int[] temp = new int[j - i + 1];
        for (int k = i; k <= j; k++){
            temp[k - i] = nums[k];
        }
        Arrays.sort(temp);
        int res = temp[1] - temp[0] == 0 ? -1 : temp[1] - temp[0];
        int right = 1;
        if (res == -1){
            while (right < temp.length){
                if (temp[0] == temp[right]){
                    right++;
                }else{
                    res = temp[right] - temp[0];
                    break;
                }
            }
        }

        for (int k = right; k < temp.length - 1; k++){
            if (temp[k] != temp[k + 1] && res > temp[k + 1] - temp[k]){
                res = temp[k + 1] - temp[k];
            }
        }
        return res;
    }


}
