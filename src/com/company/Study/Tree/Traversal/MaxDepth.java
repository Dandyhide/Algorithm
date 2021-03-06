package com.company.Study.Tree.Traversal;

/**
 * 二叉树的最大深度
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xoh1zg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

import com.company.TreeNode;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        return maxDept(root);
    }

    private int maxDept(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(maxDept(root.left), maxDept(root.right)) + 1;
    }
}
