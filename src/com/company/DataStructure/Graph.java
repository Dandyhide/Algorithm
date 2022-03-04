package com.company.DataStructure;

//临接矩阵
public class Graph {
    int V;      //顶点数量
    int E;      //边的数量
    String[] vertex;        //顶点数组
    int[][] matrix;         //邻接矩阵
    boolean[] flag;
    public Graph(int v){
        this.V = v;
        vertex = new String[v];
        matrix = new int[v][v];
        flag = new boolean[v];
        for (int i = 0; i < v; i++){
            flag[i] = false;
        }
    }
}
