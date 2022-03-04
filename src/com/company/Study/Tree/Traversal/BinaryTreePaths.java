package com.company.Study.Tree.Traversal;

//所有路径

import com.company.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        getPath(root, "", list);
        return list;
    }

    private void getPath(TreeNode root, String res,  List<String> list) {
        if (root == null){
            return;
        }
        res = res + "->" + root.val;
        if (root.left == null && root.right == null){
            list.add(res.substring(2));
        }
        getPath(root.left, res, list);
        getPath(root.right, res, list);
    }


}
