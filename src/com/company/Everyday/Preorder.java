package com.company.Everyday;

import java.util.*;

/**
 * 589. N 叉树的前序遍历
 *
 * 给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。
 *
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[1,3,5,6,2,4]
 * 示例 2：
 *
 *
 *
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 *  
 *
 * 提示：
 *
 * 节点总数在范围 [0, 104]内
 * 0 <= Node.val <= 104
 * n 叉树的高度小于或等于 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Preorder {
    /**
     * Recursion
     */
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Deque<Node> stack = new LinkedList<>();
        Deque<Node> queue = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node temp = stack.poll();
            list.add(temp.val);
            if (temp.children != null){
                for (Node child : temp.children) {
                    queue.offer(child);
                }
            }
            while (!queue.isEmpty()){
                stack.add(queue.pollLast());
            }
        }
        return list;
    }

    /**
     * Iterator
     */
    /*
    List<Integer> list = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if(root == null){
            return list;
        }
        dfs(root);
        return list;
    }

    private void dfs(Node root) {
        if (root != null){
            list.add(root.val);
        }
        if (root.children != null){
            for (Node child : root.children) {
                dfs(child);
            }
        }
    }
    */

    class Node{
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
