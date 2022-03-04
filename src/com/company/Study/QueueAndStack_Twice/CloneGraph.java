package com.company.Study.QueueAndStack_Twice;

import java.util.*;

//TODO

public class CloneGraph {
    public Node cloneGraph(Node node) {
        List<List<Node>> list = new ArrayList<>();

        return node;
    }

    class Node{
        int val;
        public List<Node> neighbors;
        public Node(int val){
            this.val = val;
        }
        public Node(int val, List<Node> neighbors){
            this.val = val;
            this.neighbors = neighbors;
        }
    }
}
