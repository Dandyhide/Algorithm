package com.company.Everyday;

/**
 * 45. 跳跃游戏 II      Medium
 *
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 *
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Jump {

    public int jump(int[] nums) {
        int step = 0;
        int max = 0;
        int next = 0;
        if (nums.length == 1){
            return 0;
        }
        if (nums[0] >= nums.length){
            return 1;
        }
        for (int i = 0; i < nums.length; i = next){
            max = 0;
            for (int j = i + 1; j <= i + nums[i]; j++){
                if (j < nums.length && j + nums[j] >= max){
                    max = j + nums[j];
                    next = j;
                }
            }
            step++;
            if (next + nums[next] >= nums.length - 1){
                step++;
                break;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        Jump jump = new Jump();
        jump.jump(new int[]{2,3,0,1,4});
    }
}
