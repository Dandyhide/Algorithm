package com.company.competition.Week_283;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2195. 向数组中追加 K 个整数
 *
 * 给你一个整数数组 nums 和一个整数 k 。请你向 nums 中追加 k 个 未 出现在 nums 中的、互不相同 的 正 整数，并使结果数组的元素和 最小 。
 *
 * 返回追加到 nums 中的 k 个整数之和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,4,25,10,25], k = 2
 * 输出：5
 * 解释：在该解法中，向数组中追加的两个互不相同且未出现的正整数是 2 和 3 。
 * nums 最终元素和为 1 + 4 + 25 + 10 + 25 + 2 + 3 = 70 ，这是所有情况中的最小值。
 * 所以追加到数组中的两个整数之和是 2 + 3 = 5 ，所以返回 5 。
 * 示例 2：
 *
 * 输入：nums = [5,6], k = 6
 * 输出：25
 * 解释：在该解法中，向数组中追加的两个互不相同且未出现的正整数是 1 、2 、3 、4 、7 和 8 。
 * nums 最终元素和为 5 + 6 + 1 + 2 + 3 + 4 + 7 + 8 = 36 ，这是所有情况中的最小值。
 * 所以追加到数组中的两个整数之和是 1 + 2 + 3 + 4 + 7 + 8 = 25 ，所以返回 25 。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i], k <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/append-k-integers-with-minimal-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MinimalKSum {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long sum = 0;
        if (nums[0] != 1){
            if (k >= nums[0] - 1){
                k = k - nums[0] + 1;
                sum += (long)nums[0] * (nums[0] - 1) / 2;
            }else{
                return (long)(1 + k) * k / 2;
            }
        }
        for (int i = 1; i < nums.length && k > 0; i++){
            if (nums[i] - nums[i - 1] > 1){
                int temp = nums[i] - nums[i - 1] - 1;
                if (k >= temp){
                    k = k - temp;
                    sum += (long)(nums[i - 1] + nums[i]) * temp / 2;
                }else{
                    sum += (long)(nums[i - 1] + 1) * k + (long)(k - 1) * k / 2;
                    k = 0;
                }
            }
        }
        if (k > 0){
            sum += (long)(nums[nums.length - 1] + 1) * k + (long)(k - 1) * k / 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        MinimalKSum minimalKSum = new MinimalKSum();
        minimalKSum.minimalKSum(new int[]{96,44,99,25,61,84,88,18,19,33,60,86,52,19,32,47,35,50,94,17,29,98,22,21,72,100,40,84}, 35);
    }
}
