package com.company.Study.QueueAndStack.Queue;

/**
 * 01 矩阵
 *
 * 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：[[0,0,0],[0,1,0],[0,0,0]]
 * 示例 2：
 *
 *
 *
 * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
 * 输出：[[0,0,0],[0,1,0],[1,2,1]]
 *  
 *
 * 提示：
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * mat[i][j] is either 0 or 1.
 * mat 中至少有一个 0 
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/queue-stack/g7pyt/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class UpdateMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Deque<int[]> deque = new LinkedList<>();
        boolean[][] visit = new boolean[m][n];
        for (boolean[] booleans : visit) {
            Arrays.fill(booleans, false);
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (mat[i][j] == 0){
                    deque.push(new int[]{i, j});
                    visit[i][j] = true;
                }
            }
        }
        bfs(mat, visit, deque);
        return mat;
    }

    private void bfs(int[][] mat, boolean[][] visit, Deque<int[]> deque) {
        int result = 0;
        while (!deque.isEmpty()){
            result++;
            int size = deque.size();
            while (size-- > 0){
                int[] temp = deque.poll();
                int row = temp[0];
                int col = temp[1];
                if (row > 0 && visit[row - 1][col] == false){
                    deque.offer(new int[]{row - 1, col});
                    visit[row - 1][col] = true;
                    mat[row - 1][col] = result;
                }
                if (row < mat.length - 1 && visit[row + 1][col] == false){
                    deque.offer(new int[]{row + 1, col});
                    visit[row + 1][col] = true;
                    mat[row + 1][col] = result;
                }
                if (col > 0 && visit[row][col - 1] == false){
                    deque.offer(new int[]{row, col - 1});
                    visit[row][col - 1] = true;
                    mat[row][col - 1] = result;
                }
                if (col < mat[0].length - 1 && visit[row][col + 1] == false){
                    deque.offer(new int[]{row, col + 1});
                    visit[row][col + 1] = true;
                    mat[row][col + 1] = result;
                }
            }
        }
    }
}
