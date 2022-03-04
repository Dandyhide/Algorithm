package com.company.Study.Tree.Summay;

/**
 * 106. 从中序与后序遍历序列构造二叉树         Medium
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import com.company.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {

    Map<Integer, Integer> map = new HashMap<>();
    int[] res;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        res = postorder;
        return buildTree(0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int li, int lj, int ri, int rj){
        if (li > lj || ri > rj){
            return null;
        }
        TreeNode root = new TreeNode(res[rj]);
        int temp = map.get(res[rj]);
        root.left = buildTree(li, temp - 1, ri, ri + temp - li - 1);
        root.right = buildTree(temp + 1, lj, ri + temp - li, rj - 1);
        return root;
    }
}
