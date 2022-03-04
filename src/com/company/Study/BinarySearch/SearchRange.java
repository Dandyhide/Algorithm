package com.company.Study.BinarySearch;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/binary-search/xenp13/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0){
            return new int[]{-1, -1};
        }
        int left = search(nums, target, true);
        int right = search(nums, target, false);
        return new int[]{left, right};
    }

    private int search(int[] nums, int target, boolean b) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                if (b){
                    right = mid;    //找最小下标
                }else{
                    left = mid;     //找最大下标
                }
            }else if (nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        if (b){
            if (nums[left] == target){
                return left;
            }else if (nums[right] == target){
                return right;
            }
            return -1;
        }else{
            if (nums[right] == target){
                return right;
            }else if (nums[left] == target){
                return left;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{5,7,7,8,8,10};
        SearchRange searchRange = new SearchRange();
        searchRange.searchRange(a, 8);
    }
}
