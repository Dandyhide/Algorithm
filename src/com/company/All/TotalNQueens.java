package com.company.All;

/**
 * 52. N皇后 II       Hard
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;

public class TotalNQueens {
    ArrayList<Integer> list = new ArrayList<Integer>();
    int result = 0;
    public int totalNQueens(int n) {
        execute(0, n);
        return result;
    }

    public void execute(int i, int n){
        if(i == n){
            ++result;
        }else{
            for(int j = 0; j < n; j++){
                if(judge(i, j)){
                    list.add(j);
                    execute(i + 1, n);
                    list.remove(i);
                }
            }
        }
    }

    private boolean judge(int i, int j) {
        for(int k = 0; k < i; k++){
            int temporary = list.get(k);
            if(temporary == j || temporary - j == i - k || temporary - j == k - i ){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TotalNQueens totalNQueens = new TotalNQueens();
        for (int i = 1; i <= 9; i++){
            System.out.println(totalNQueens.totalNQueens(i));
        }

    }
}
