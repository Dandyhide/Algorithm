package com.company.Everyday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2049. 统计最高分的节点数目     Medium
 *
 * 给你一棵根节点为 0 的 二叉树 ，它总共有 n 个节点，节点编号为 0 到 n - 1 。同时给你一个下标从 0 开始的整数数组 parents 表示这棵树，其中 parents[i] 是节点 i 的父节点。由于节点 0 是根，所以 parents[0] == -1 。
 *
 * 一个子树的 大小 为这个子树内节点的数目。每个节点都有一个与之关联的 分数 。求出某个节点分数的方法是，将这个节点和与它相连的边全部 删除 ，剩余部分是若干个 非空 子树，这个节点的 分数 为所有这些子树 大小的乘积 。
 *
 * 请你返回有 最高得分 节点的 数目 。
 *
 *  
 *
 * 示例 1:
 *
 *
 *
 * 输入：parents = [-1,2,0,2,0]
 * 输出：3
 * 解释：
 * - 节点 0 的分数为：3 * 1 = 3
 * - 节点 1 的分数为：4 = 4
 * - 节点 2 的分数为：1 * 1 * 2 = 2
 * - 节点 3 的分数为：4 = 4
 * - 节点 4 的分数为：4 = 4
 * 最高得分为 4 ，有三个节点得分为 4 （分别是节点 1，3 和 4 ）。
 * 示例 2：
 *
 *
 *
 * 输入：parents = [-1,2,0]
 * 输出：2
 * 解释：
 * - 节点 0 的分数为：2 = 2
 * - 节点 1 的分数为：2 = 2
 * - 节点 2 的分数为：1 * 1 = 1
 * 最高分数为 2 ，有两个节点分数为 2 （分别为节点 0 和 1 ）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-nodes-with-the-highest-score
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class CountHighestScoreNodes {

    int len;
    List<Integer>[] list;
    long max = 0;
    int count = 0;

    public int countHighestScoreNodes(int[] parents) {
        len = parents.length;
        list = new List[len];
        for (int i = 0; i < len ;i++){
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < len; i++){
            if (parents[i] != -1){
                list[parents[i]].add(i);
            }
        }
        dfs(0);
        return count;
    }

    private int dfs(int index){
        int size = len - 1;
        long score = 1;
        for (Integer val : list[index]) {
            int temp = dfs(val);
            score *= temp;
            size -= temp;
        }
        if (index != 0){
            score *= size;
        }
        if (score > max){
            max = score;
            count = 1;
        }else if(score == max){
            count++;
        }
        return len - size;
    }


    /**
     * 超时
     *
     *
    Map<Integer, int[]> map = new HashMap<>();
    boolean[] flag;

    public int countHighestScoreNodes(int[] parents) {
        int len = parents.length;
        flag = new boolean[len];
        dfs(0, parents);
        int max = 0, count = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int left = entry.getValue()[0] > 0 ? entry.getValue()[0] : 1;
            int right = entry.getValue()[1] > 0 ? entry.getValue()[1] : 1;
            int prev = len - entry.getValue()[0] - entry.getValue()[1] - 1 > 0 ? len - entry.getValue()[0] - entry.getValue()[1] - 1 : 1;
            int temp = left * right * prev;
            if (temp > max) {
                max = temp;
                count = 1;
            } else if (temp == max) {
                count++;
            }
        }
        return count;
    }

    private int dfs(int val, int[] parent) {
        int left = 0, right = 0;
        boolean control = true;
        for (int i = 1; i < parent.length; i++) {
            if (val == parent[i]) {
                if (!flag[i] && control) {
                    control = false;
                    flag[i] = true;
                    left = dfs(i, parent);
                    if (map.containsKey(val)) {
                        map.get(val)[0] = left;
                    } else {
                        int[] temp = new int[2];
                        temp[0] = left;
                        map.put(val, temp);
                    }
                }
                if (val == parent[i] && !flag[i]) {
                    flag[i] = true;
                    right = dfs(i, parent);
                    if (map.containsKey(val)) {
                        map.get(val)[1] = right;
                    } else {
                        int[] temp = new int[2];
                        temp[1] = right;
                        map.put(val, temp);
                    }
                }
            }
        }
        if (!map.containsKey(val)) {
            map.put(val, new int[2]);
        }
        return left + right + 1;
    }

     */

    public static void main(String[] args) {
        CountHighestScoreNodes countHighestScoreNodes = new CountHighestScoreNodes();
        countHighestScoreNodes.countHighestScoreNodes(new int[]{});
    }
}