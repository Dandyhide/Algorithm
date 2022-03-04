package com.company.Study.QueueAndStack.Stack;

import com.company.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    
    List<Integer> list = new ArrayList<>();
    
    public List<Integer> inorderTraversal(TreeNode root) {
        getResult(root);
        return list;
    }

    private void getResult(TreeNode root) {
        if (root == null){
            return;
        }
        getResult(root.left);
        list.add(root.val);
        getResult(root.right);
    }
}
