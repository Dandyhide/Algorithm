package com.company.All;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值     Hard
 *
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] arr = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(0);
        for (int i = 1; i < k; i++){
            while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]){
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        for (int i = k; i < nums.length; i++) {
            arr[i - k] = nums[queue.peekFirst()];
            while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]){
                queue.pollLast();
            }
            queue.offerLast(i);
            while (queue.peekFirst() <= i - k){
                queue.pollFirst();
            }
        }
        arr[arr.length - 1] = queue.peek();
        return arr;
    }

    /**
     * 队列存的元素过多
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] arr = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(nums[0]);
        for (int i = 1; i < k; i++){
            while (!queue.isEmpty() && queue.getLast() < nums[i]){
                queue.pollLast();
            }
            while (queue.size() < i){
                queue.offerLast(nums[i]);
            }
        }
        for (int i = k; i < nums.length; i++) {
            arr[i - k] = queue.pollFirst();
            while (!queue.isEmpty() && queue.getLast() < nums[i]){
                queue.pollLast();
            }
            while (queue.size() < k){
                queue.offerLast(nums[i]);
            }
        }
        arr[arr.length - 1] = queue.peek();
        return arr;
    }
     **/
}
