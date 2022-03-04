package com.company.Everyday;

/**
 * 384. 打乱数组        Medium      NNNNNNNNNNNNNNNNN
 *
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
 *
 * 实现 Solution class:
 *
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 *  
 *
 * 示例：
 *
 * 输入
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * 输出
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 *
 * 解释
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
 * solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
 * solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * -106 <= nums[i] <= 106
 * nums 中的所有元素都是 唯一的
 * 最多可以调用 5 * 104 次 reset 和 shuffle
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shuffle-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {

    public int[] nums;
    public int[] ints;
    public int len;
    public List<Integer> list;

    public Solution(int[] nums) {
        this.len = nums.length;
        this.nums = new int[len];
        this.ints = new int[len];
        for (int i = 0; i < nums.length; i++){
            this.nums[i] = nums[i];
        }
        this.ints = nums;
        this.list = new ArrayList<>();
        resetList();
    }

    public int[] reset() {
        nums = ints;
        resetList();
        return nums;
    }

    public int[] shuffle() {
        int k = len;
        Random random = new Random();
        while (k > 0){
            int i = random.nextInt(k);
            System.out.println(k);
            System.out.println(i);
            nums[k - 1] = list.get(i);
            list.remove(i);
            k--;
        }
        resetList();
        return nums;
    }

    public void resetList(){
        list.clear();
        for (int i = 0; i < len; i++){
            list.add(nums[i]);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1,2,3});
        solution.shuffle();
    }
}
