package com.company.competition.MT0312;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 回溯，暴力解决  暂时没想到更好的办法
 */
public class SolutionDC {

    static boolean[] flag;
    static int reuslt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        flag = new boolean[m + 1];
        dfs(0, n, arr, 0);
        System.out.println(reuslt);
    }

    private static void dfs(int k, int n, int[][] arr, int val){
        if (k >= n){
            reuslt = Math.max(reuslt, val);
            return;
        }
        dfs(k + 1, n, arr, val);
        if (!flag[arr[k][0]] && !flag[arr[k][1]]){
            flag[arr[k][0]] = true;
            flag[arr[k][1]] = true;
            dfs(k + 1, n, arr, val + 1);
            flag[arr[k][0]] = false;
            flag[arr[k][1]] = false;
        }
    }
}
