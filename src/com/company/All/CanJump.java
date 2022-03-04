package com.company.All;

/**
 * 55. 跳跃游戏     Medium
 *
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标
 */

public class CanJump {
    public boolean canJump(int[] nums) {
        if (nums.length == 1){
            return true;
        }
        return execute(nums, 0);
    }

    private boolean execute(int[] nums, int i) {
        if (nums[i] + i >= nums.length){
            return true;
        }
        if (nums[i] == 0){
            return false;
        }
        int key = i;
        int max = 0;
        for (int j = i; j <= i + nums[i]; j++){
            if (j + nums[j] > max){
                max = j + nums[j];
                key = j;
            }
        }
        return execute(nums, key);
    }
}
