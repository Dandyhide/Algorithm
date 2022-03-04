package com.company.Study.Tree.Summay;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 *
 *  
 *
 * 示例 1:
 *
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * 示例 2:
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *  
 *
 * 提示:
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均无重复元素
 * inorder 均出现在 preorder
 * preorder 保证为二叉树的前序遍历序列
 * inorder 保证为二叉树的中序遍历序列
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xoei3r/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

import com.company.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTreePreAndIn {
    Map<Integer, Integer> map = new HashMap<>();
    int[] res;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        res = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = buildTree(0, preorder.length - 1, 0, inorder.length - 1);
        return root;
    }

    private TreeNode buildTree(int li, int lj, int ri, int rj) {
        if (li > lj || ri > rj){
            return null;
        }
        TreeNode root = new TreeNode(res[li]);
        int temp = map.get(res[li]);
        root.left = buildTree(li + 1, li + temp - ri, ri, temp - 1);
        root.right = buildTree(lj - rj + temp + 1, lj, temp + 1, rj);
        return root;
    }
}
