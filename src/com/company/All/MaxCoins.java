package com.company.All;

import java.util.*;

/**
 * 312. 戳气球     Hard
 *
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 *
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 *
 * 求所能获得硬币的最大数量。
 *
 *  
 *
 * 示例 1：
 * 输入：nums = [3,1,5,8]
 * 输出：167
 * 解释：
 * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
 * coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
 * 示例 2：
 *
 * 输入：nums = [1,5]
 * 输出：10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MaxCoins {
    public int maxCoins(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < nums.length - 1; i++){
            list.add(nums[i]);
            set.add(nums[i]);
        }
        List<Integer> sortList = new ArrayList<>(set);
        Collections.sort(sortList);
        int result = 0;
        for (Integer i : sortList) {
            while (list.contains(i)){
                int temp = list.indexOf(i);
                if (temp == 0){
                    if (list.size() > 1){
                        result += nums[0] * list.get(temp) * list.get(temp + 1);
                    }else{
                        result += nums[0] * list.get(temp) * nums[nums.length - 1];
                    }
                }else if (temp == list.size() - 1){
                    if (list.size() > 1){
                        result += list.get(temp - 1) * list.get(temp) * nums[nums.length - 1];
                    }else{
                        result += nums[0] * list.get(temp) * nums[nums.length - 1];
                    }
                }else{
                    result += list.get(temp - 1) * list.get(temp) * list.get(temp + 1);
                }
                list.remove(temp);
            }
        }
        return result + nums[0] * nums[nums.length - 1] + Math.max(nums[0], nums[nums.length - 1]);
    }

    public static void main(String[] args) {
        MaxCoins maxCoins = new MaxCoins();
        maxCoins.maxCoins(new int[]{3,5,8,5,2});
    }
}
