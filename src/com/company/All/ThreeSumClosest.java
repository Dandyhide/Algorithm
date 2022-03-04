package com.company.All;

/**
 * 16. 最接近的三数之和   Medium
 *
 *给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *  
 *
 * 提示：
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 * 通过次数222,859提交次数484,980
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//TODO   尝试非暴力解法

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++){
            for (int j = i + 1; j < nums.length - 1; j++){
                for (int k = j + 1; k < nums.length; k++){
                    int temp = nums[i] + nums[j] + nums[k] - target;
                    if (Math.abs(temp - target) < Math.abs(min)){
                        min = temp;
                    }
                }
            }
        }
        return target - min;
    }
}
