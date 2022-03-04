package com.company.All;

/**
 * 18. 四数之和     Medium
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：答案中不可以包含重复的四元组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 *
 * 输入：nums = [], target = 0
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int m = 0; m < nums.length - 3;){
            for (int n = nums.length - 1; n > m + 2;){
                int left = m + 1, right = n - 1;
                while (left < right){
                    int temp = nums[m] + nums[n] + nums[left] + nums[right];
                    if (temp == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[m]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        list.add(nums[n]);
                        res.add(list);
                        int k = left + 1;
                        while (nums[k] == nums[left] && k < n){
                            k++;
                        }
                        left = k;
                        k = right - 1;
                        while (nums[k] == nums[right] && k > m){
                            k--;
                        }
                        right = k;
                    }else if (temp < target){
                        int k = left + 1;
                        while (nums[k] == nums[left] && k < n){
                            k++;
                        }
                        left = k;
                    }else if (temp > target){
                        int k = right - 1;
                        while (nums[k] == nums[right] && k > m){
                            k--;
                        }
                        right = k;
                    }
                }
                int k = n - 1;
                while (nums[k] == nums[n] && k > m){
                    k--;
                }
                n = k;
            }
            int k = m + 1;
            while (nums[k] == nums[m] && k < nums.length - 3){
                k++;
            }
            m = k;
        }
        return res;
    }
}
