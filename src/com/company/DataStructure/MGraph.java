package com.company.DataStructure;

import java.util.ArrayList;
import java.util.List;

//邻接表
public class MGraph {
    int V;      //顶点数
    int E;      //边的数量
    List[]  adj;    //临接表
    boolean[] flag; //是否访问标识
    public  MGraph(int v){
        this.V = v;
        adj = new ArrayList[v];
        flag = new boolean[v];
        for (int i = 0; i < v; i++){
            adj[i] = new ArrayList();
            flag[i] = false;
        }
    }
}
