package com.company.All;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II      Medium
 *
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合。 
 *
 *  
 *
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 *  
 *
 * 提示:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class CombinationSum2 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    List<int[]> flag = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int num : candidates) {
            int size = flag.size();
            if (flag.isEmpty() || num != flag.get(size - 1)[0]){
                flag.add(new int[]{num, 1});
            }else{
                ++flag.get(size - 1)[1];
            }
        }
        System.out.println(flag.size());
        dfs(0, target);
        return result;
    }

    private void dfs(int pos, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (pos == flag.size() || target < flag.get(pos)[0]) {
            return;
        }
        dfs(pos + 1, target);
        int most = Math.min(target / flag.get(pos)[0], flag.get(pos)[1]);
        for (int i = 1; i <= most; i++){
            list.add(flag.get(pos)[0]);
            dfs(pos + 1, target - i * flag.get(pos)[0]);
        }
        for (int i = 1; i <= most; i++){
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        combinationSum2.combinationSum2(new int[]{1,1,1,1,2,2,2}, 5);
    }
}
