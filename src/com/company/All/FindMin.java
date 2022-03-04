package com.company.All;

public class FindMin {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = (left + right) >>> 1;
            if (nums[mid] > nums[left]){
                left = mid;
            }else if (nums[mid] < nums[left]){
                right = mid;
            }else{
                return nums[right];
            }
        }
        return nums[right];
    }
}
