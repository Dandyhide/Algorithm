package com.company.Study.Tree.Summay;

/**
 * 填充每个节点的下一个右侧节点指针
 */

import com.company.Node;

public class Connect2 {
    public Node connect(Node root) {
        if (root == null){
            return root;
        }
        dfs(root.left, root.right);
        return root;
    }

    private void dfs(Node left, Node right) {
        if (left != null){
            left.next = right;
            dfs(left.left, left.right);
        }
        if (left != null && right != null){
            dfs(left.right, right.left);
        }
        if (right != null){
            dfs(right.left, right.right);
        }
    }
}
