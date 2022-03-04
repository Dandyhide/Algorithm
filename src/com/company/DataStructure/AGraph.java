package com.company.DataStructure;

import java.util.ArrayList;
import java.util.List;

public class AGraph {
    int V;
    int E;
    String[] vertex;    //顶点数组
    int[][] matrix;     //链接矩阵
    List[] adj;         //邻接表
    boolean[] flag;     //判断顶点是否访问
    public AGraph(int v){
        this.V = v;
        vertex = new String[v];
        matrix = new int[v][v];
        adj = new ArrayList[v];
        flag = new boolean[v];
        for (int i = 0; i < v; i++){
            adj[i] = new ArrayList();
            flag[i] = false;
        }
    }
}
