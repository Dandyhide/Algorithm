package com.company.Study.Tree.Traversal;

/**
 * 对称二叉树
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *  
 *
 * 进阶：
 *
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xoxzgv/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

import com.company.TreeNode;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return checkEqual(root.left, root.right);
    }

    private boolean checkEqual(TreeNode left, TreeNode right) {
        if (left == null && right == null){
            return true;
        }
        if ((left == null || right == null)){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        return checkEqual(left.left, right.right) && checkEqual(left.right, right.left);
    }
}
