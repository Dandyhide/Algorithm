package com.company.All;

import java.util.Arrays;

/**
 * 179. 最大数         Medium
 *
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 *
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 *
 * 输入：nums = [10]
 * 输出："10"
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LargestNumber {
    public String largestNumber(int[] nums) {
        sortArrays(nums, 0, nums.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }

    public void sortArrays(int[] nums, int i, int j){
        if (i < j){
            int temp = nums[i], m = i, n = j;
            while (i < j){
                while (i < j && !compara(nums[j], temp)){
                    j--;
                }
                if (i < j){
                    nums[i] = nums[j];
                }
                while (i < j && compara(nums[i], temp)){
                    i++;
                }
                if (i < j){
                    nums[j] = nums[i];
                }
            }
            nums[i] = temp;
            sortArrays(nums, m, i - 1);
            sortArrays(nums, i + 1, n);
        }
    }

    private boolean compara(int m, int n) {
        String i = m + "";
        String j = n + "";
        if (i.startsWith(j) || j.startsWith(i)){
            return m > n ? false : true;
        }
        return (m+"").compareTo(n+"") > 0;
    }

    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        System.out.println(largestNumber.compara(3, 9));
    }
}
