package com.company.Study.Tree.Traversal;

import com.company.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//TODO          TODO            TODO            TODO            TODO

public class PostorderTraversal_iterator {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev){
                list.add(root.val);
                prev = root;
                root = null;
            }else{
                stack.push(root);
                root = root.right;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;
        PostorderTraversal_iterator postorderTraversal_iterator = new PostorderTraversal_iterator();
        postorderTraversal_iterator.postorderTraversal(root);
    }
}
