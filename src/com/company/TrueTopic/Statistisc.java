package com.company.TrueTopic;

import com.company.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Statistisc {
    public int count(TreeNode treeNode){
        if (treeNode == null){
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        int count = 0;
        queue.offer(treeNode);
        while (!queue.isEmpty()){
            int size = queue.size();
            count += size;
            while (size-- > 0){
                TreeNode root = queue.poll();
                if (root.left != null){
                    queue.offer(root.left);
                }
                if (root.right != null){
                    queue.offer(root.right);
                }
            }
        }
        return count;
    }
}
