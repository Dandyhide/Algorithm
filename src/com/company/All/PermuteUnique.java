package com.company.All;

import java.util.*;

/**
 * 47. 全排列 II       Medium
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class PermuteUnique {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] flag = new boolean[nums.length];
        Arrays.fill(flag, false);
        execute(nums, 0, new ArrayList<>(), flag);
        return result;
    }

    private void execute(int[] nums, int k, List<Integer> list, boolean[] flag) {
        if (list.size() == nums.length){
            if (!result.contains(list)){
                result.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (!flag[i]){
                flag[i] = true;
                list.add(nums[i]);
                execute(nums, k + 1, list, flag);
                list.remove(k);
                flag[i] = false;
            }

        }
    }

    public static void main(String[] args) {
        PermuteUnique permuteUnique = new PermuteUnique();
        permuteUnique.permuteUnique(new int[]{1,2,1});
    }
}
