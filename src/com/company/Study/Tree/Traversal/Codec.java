package com.company.Study.Tree.Traversal;

import com.company.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return "#";
        }
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if (temp == null){
                sb.append("#,");
                continue;
            }
            sb.append(temp.val + ",");
            queue.add(temp.left);
            queue.add(temp.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("#")){
            return null;
        }
        String[] split = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < split.length; i = i + 2){
            TreeNode parent = queue.poll();
            if (!"#".equals(split[i])){
                TreeNode temp = new TreeNode(Integer.parseInt(split[i]));
                parent.left = temp;
                queue.add(temp);
            }
            if (!"#".equals(split[i + 1])){
                TreeNode temp = new TreeNode(Integer.parseInt(split[i + 1]));
                parent.right = temp;
                queue.add(temp);
            }
        }
        return root;
    }
}
