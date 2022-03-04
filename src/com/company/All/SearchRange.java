package com.company.All;

//TODO

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int left = -1, right = -1;
        int index = getIndex(nums, 0, nums.length - 1, target);
        if (index > -1){
            left = index;
            while (left > -1 && nums[left] == target){
                left = getIndex(nums, 0, left, target);
            }
            while (right < nums.length && nums[right] == target){
                right = getIndex(nums, right, nums.length, target);
            }
        }
        return null;
    }

    public int getIndex(int[] nums, int left, int right, int target){
        if (left > right){
            return -1;
        }
        int mid = (left + right) >> 1;
        if (target == nums[mid]){
            return mid;
        }else if (target < nums[mid]){
            return getIndex(nums, left, mid - 1, target);
        }else {
            return getIndex(nums, mid + 1, right,target);
        }
    }
}
