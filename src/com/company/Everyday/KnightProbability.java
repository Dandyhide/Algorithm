package com.company.Everyday;

/**
 * 688. 骑士在棋盘上的概率       Medium
 *
 * 在一个 n x n 的国际象棋棋盘上，一个骑士从单元格 (row, column) 开始，并尝试进行 k 次移动。行和列是 从 0 开始 的，所以左上单元格是 (0,0) ，右下单元格是 (n - 1, n - 1) 。
 *
 * 象棋骑士有8种可能的走法，如下图所示。每次移动在基本方向上是两个单元格，然后在正交方向上是一个单元格。
 *
 *
 *
 * 每次骑士要移动时，它都会随机从8种可能的移动中选择一种(即使棋子会离开棋盘)，然后移动到那里。
 *
 * 骑士继续移动，直到它走了 k 步或离开了棋盘。
 *
 * 返回 骑士在棋盘停止移动后仍留在棋盘上的概率 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: n = 3, k = 2, row = 0, column = 0
 * 输出: 0.0625
 * 解释: 有两步(到(1,2)，(2,1))可以让骑士留在棋盘上。
 * 在每一个位置上，也有两种移动可以让骑士留在棋盘上。
 * 骑士留在棋盘上的总概率是0.0625。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/knight-probability-in-chessboard
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class KnightProbability {

    public double knightProbability(int n, int k, int row, int column) {
        int[][] direction = new int[][]{{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};
        double[][][] dp = new double[n][n][k + 1];
        for (int step = 0; step < k; step++){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if (step == 0){
                        dp[i][j][step] = 1;
                    }else{
                        for (int m = 0; m < direction.length; m++){
                            int ni = i + direction[m][0], nj = j + direction[m][1];
                            if (ni >= 0 && ni < n && nj >= 0 && nj < n){
                                dp[i][j][step] += dp[ni][nj][step - 1] / 8;
                            }
                        }
                    }
                }
            }
        }
        return dp[row][column][k];
    }


    /**
     * Error   超时
     * @param args
     */
//    int[][] direction = new int[][]{{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};
//    double stepSuccess = 0;
//
//    public double knightProbability(int n, int k, int row, int column) {
//        move(row, column, 0, n, k);
//        return stepSuccess / Math.pow(8, n);
//    }
//
//    public void move(int row, int column, int i, int n, int k){
//        if (!check(row, column, n)){
//            return;
//        }
//        if (i >= k){
//            stepSuccess++;
//            System.out.println(row + " " + column);
//            return;
//        }
//        for (int j = 0; j < direction.length; j++){
//            move(row + direction[j][0], column + direction[j][1], i + 1, n, k);
//        }
//    }
//
//    public boolean check(int row, int column, int n){
//        if (row >= 0 && row < n && column >= 0 && column < n){
//            return true;
//        }
//        return false;
//    }

    public static void main(String[] args) {
        KnightProbability knightProbability = new KnightProbability();
        knightProbability.knightProbability(3, 2, 0, 0);
    }
}
