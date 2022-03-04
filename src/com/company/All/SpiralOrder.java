package com.company.All;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 54. 螺旋矩阵     MEDIUM
 *
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length + 2, n = matrix[0].length + 2;
        boolean[][] flag = new boolean[m][n];
        Arrays.fill(flag[0], true);
        Arrays.fill(flag[m - 1], true);
        for (int i = 0; i < m; i++){
            flag[i][0] = true;
        }
        for (int i = 0; i < m; i++){
            flag[i][n - 1] = true;
        }
        int i = 1, j = 1;
        int direct = 1;
        while(true){
            list.add(matrix[i - 1][j - 1]);
            flag[i][j] = true;
            if (direct == 1) {
                if(!flag[i][j + 1]){
                    j++;
                }else{
                    i++;
                    direct++;
                }
            }else if (direct == 2) {
                if(!flag[i + 1][j]){
                    i++;
                }else{
                    j--;
                    direct++;
                }
            }else if (direct == 3) {
                if(!flag[i][j - 1]){
                    j--;
                }else{
                    i--;
                    direct++;
                }
            }else if (direct == 4) {
                if(!flag[i - 1][j]){
                    i--;
                }else{
                    j++;
                    direct = 1;
                }
            }
            if(i >= m || j >= n){
                break;
            }
            if (flag[i][j] && flag[i - 1][j] && flag[i + 1][j] && flag[i][j - 1] && flag[i][j + 1]){
                break;
            }
        }
        return list;
    }
}
