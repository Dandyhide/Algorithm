package com.company.competition.Week_283;

import com.company.TreeNode;

import java.util.*;

/**
 * 2196. 根据描述创建二叉树      Medium
 *
 * 给你一个二维整数数组 descriptions ，其中 descriptions[i] = [parenti, childi, isLefti] 表示 parenti 是 childi 在 二叉树 中的 父节点，二叉树中各节点的值 互不相同 。此外：
 *
 * 如果 isLefti == 1 ，那么 childi 就是 parenti 的左子节点。
 * 如果 isLefti == 0 ，那么 childi 就是 parenti 的右子节点。
 * 请你根据 descriptions 的描述来构造二叉树并返回其 根节点 。
 *
 * 测试用例会保证可以构造出 有效 的二叉树。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：descriptions = [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]
 * 输出：[50,20,80,15,17,19]
 * 解释：根节点是值为 50 的节点，因为它没有父节点。
 * 结果二叉树如上图所示。
 * 示例 2：
 *
 *
 *
 * 输入：descriptions = [[1,2,1],[2,3,0],[3,4,1]]
 * 输出：[1,2,null,null,3,4]
 * 解释：根节点是值为 1 的节点，因为它没有父节点。
 * 结果二叉树如上图所示。
 *  
 *
 * 提示：
 *
 * 1 <= descriptions.length <= 104
 * descriptions[i].length == 3
 * 1 <= parenti, childi <= 105
 * 0 <= isLefti <= 1
 * descriptions 所描述的二叉树是一棵有效二叉树
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/create-binary-tree-from-descriptions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class CreateBinaryTree {

    Map<Integer, List<Integer>> map = new HashMap<>();

    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < descriptions.length; i++){
            set.add(descriptions[i][1]);
            if (map.containsKey(descriptions[i][0])){
                map.get(descriptions[i][0]).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(descriptions[i][0], list);
            }
        }
        int rootVal = -1;
        for (int[] description : descriptions) {
            if (!set.contains(description[0])){
                rootVal = description[0];
                break;
            }
            if (!set.contains(description[1])){
                rootVal = description[1];
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = dfs(root.val,1, descriptions);
        root.right = dfs(root.val,0,descriptions);
        return root;
    }

    private TreeNode dfs(int val, int i, int[][] descriptions) {
        if (map.containsKey(val)){
            List<Integer> list = map.get(val);
            for (Integer index : list) {
                int[] description = descriptions[index];
                if (i == 1 && description[2] == 1){
                    TreeNode left = new TreeNode(description[1]);
                    left.left = dfs(left.val, 1, descriptions);
                    left.right = dfs(left.val, 0, descriptions);
                    return left;
                }else if(i == 0 && description[2] == 0){
                    TreeNode right = new TreeNode(description[1]);
                    right.left = dfs(right.val, 1, descriptions);
                    right.right = dfs(right.val, 0, descriptions);
                    return right;
                }
            }

        }
        return null;
    }
}
