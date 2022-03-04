package com.company.Study.Tree.Traversal;

import com.company.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//TODO      TODO        TODO        TODO        TODO

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0){
                TreeNode t = queue.poll();
                if (t != null){
                    temp.add(t.val);
                }
                if (t.left != null){
                    queue.offer(t.left);
                }
                if (t.right != null){
                    queue.offer(t.right);
                }
            }
            list.add(temp);
        }
        return list;
    }
}
