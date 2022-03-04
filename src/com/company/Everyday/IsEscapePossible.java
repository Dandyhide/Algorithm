package com.company.Everyday;

public class IsEscapePossible {

    int[][] direction = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    boolean[][] flag = new boolean[1000000][1000000];
    int target[];
    int[][] blocked;
    int len = 1000000;
    boolean result;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        this.target = target;
        this.blocked = blocked;
        execute(source[0], source[1]);
        return result;
    }

    public void execute(int m, int n){
        if (m == target[0] && n == target[1]){
            result = true;
        }
        if (m < 0 || n < 0 || m >= len || n >= len){
            return;
        }
        if (blocked[m][n] == 1){
            return;
        }
        if (flag[m][n]){
            return;
        }
        flag[m][n] = true;
        for (int i = 0; i < direction.length; i++){
            execute(m + direction[i][0], n + direction[i][1]);
        }
    }
}
