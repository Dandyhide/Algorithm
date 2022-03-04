package com.company.Study.Hash;

import com.company.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {

    List<TreeNode> list = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        collect(root);
        return list;
    }

    private String collect(TreeNode root) {
        if (root == null){
            return "#";
        }
        String serial = root.val + "," + collect(root.left) + "," + collect(root.right);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        if (map.get(serial) == 2){
            list.add(root);
        }
        return serial;
    }
}
