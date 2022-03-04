package com.company.Everyday;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 *
 * 统计一个数字在排序数组中出现的次数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *  
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Search {
    public int search(int[] nums, int target) {
        int left = getIndex(nums, target,true);
        int right = getIndex(nums, target, false);
        if (left == -1 && right == -1){
            return 0;
        }
        return right - left + 1;
    }

    private int getIndex(int[] nums, int target, boolean flag) {
        int left = 0, right = nums.length;
        if (left < right){
            int mid = (left + right) >> 1;
            if (target == nums[mid]){
                if (flag){
                    left = mid - 1;
                }else{
                    right = mid + 1;
                }
            } else if(target > nums[mid]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
}
