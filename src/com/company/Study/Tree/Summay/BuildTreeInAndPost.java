package com.company.Study.Tree.Summay;

/**
 * 从中序与后序遍历序列构造二叉树
 */

import com.company.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeInAndPost {
    Map<Integer, Integer> map = new HashMap<>();
    int[] res;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        res = postorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root  = buildTree(0, inorder.length - 1, 0, postorder.length - 1);
        return root;
    }

    private TreeNode buildTree(int li, int lj, int ri, int rj) {
        if (li > lj || ri > rj){
            return null;
        }
        TreeNode root = new TreeNode(res[rj]);
        int temp = map.get(res[rj]);
        root.left = buildTree(li, temp - 1, ri, ri + temp - li - 1);
        root.right = buildTree(temp + 1, lj, rj - lj + temp,rj - 1);
        return root;
    }
}
