package com.company.All;

/**
 * 114. 二叉树展开为链表        Medium
 *
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [0]
 * 输出：[0]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import com.company.TreeNode;

public class Flatten {
    public void flatten(TreeNode root) {
        while (root != null){
            if (root.left != null){
                TreeNode tempRight = root.left;
                while (tempRight.right != null){
                    tempRight = tempRight.right;
                }
                tempRight.right = root.right;
                root.right = root.left;
            }
            root.left = null;
            root = root.right;
        }
    }
}
