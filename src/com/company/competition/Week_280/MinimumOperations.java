package com.company.competition.Week_280;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2170. 使数组变成交替数组的最少操作数
 *
 * 给你一个下标从 0 开始的数组 nums ，该数组由 n 个正整数组成。
 *
 * 如果满足下述条件，则数组 nums 是一个 交替数组 ：
 *
 * nums[i - 2] == nums[i] ，其中 2 <= i <= n - 1 。
 * nums[i - 1] != nums[i] ，其中 1 <= i <= n - 1 。
 * 在一步 操作 中，你可以选择下标 i 并将 nums[i] 更改 为 任一 正整数。
 *
 * 返回使数组变成交替数组的 最少操作数 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-operations-to-make-the-array-alternating
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MinimumOperations {
    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> even = new HashMap<>();
        Map<Integer, Integer> odd = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (i % 2 == 0){
                even.put(nums[i], even.getOrDefault(nums[i], 0) + 1);
            }else{
                odd.put(nums[i], odd.getOrDefault(nums[i], 0) + 1);
            }
        }
        int evenMax1 = 0, evenMax2 = 0;
        List<Integer> evenKeyList = new ArrayList<>();
        for (Integer key1 : even.keySet()) {
            evenMax1 = Math.max(even.get(key1), evenMax1);
        }
        for (Integer key : even.keySet()) {
            if (even.get(key) == evenMax1){
                evenKeyList.add(key);
            }
        }
        int oddMax1 = 0, oddMax2 = 0;
        List<Integer> oddKeyList = new ArrayList<>();
        for (Integer key : odd.keySet()) {
            oddMax1 = Math.max(odd.get(key), oddMax1);
        }
        for (Integer key : odd.keySet()) {
            if (odd.get(key) == oddMax1){
                oddKeyList.add(key);
            }
        }
        if ((evenKeyList.size() > 1 || oddKeyList.size() > 1) || (evenKeyList.get(0) != oddKeyList.get(0))){
            return nums.length - evenMax1 - oddMax1;
        }
        for (Integer key : even.keySet()) {
            if (key != evenKeyList.get(0)){
                evenMax2 = Math.max(even.get(key), evenMax2);
            }
        }
        for (Integer key : odd.keySet()) {
            if (key != oddKeyList.get(0)){
                oddMax2 = Math.max(odd.get(key), oddMax2);
            }
        }
        if (evenMax2 >= oddMax2){
            return nums.length - evenMax2 - oddMax1;
        }else{
            return nums.length - evenMax1 - oddMax2;
        }
    }
}
