package com.company.Study.Tree.Traversal;

/**
 * 二叉树的中序遍历
 *
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 *
 *
 * 输入：root = [1,2]
 * 输出：[2,1]
 * 示例 5：
 *
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *  
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *  
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xecaj6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

import com.company.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Inorder(root, list);
        return list;
    }

    public void Inorder(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        Inorder(root.left, list);
        list.add(root.val);
        Inorder(root.right, list);
    }
}
