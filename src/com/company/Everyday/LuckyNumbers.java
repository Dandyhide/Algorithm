package com.company.Everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 1380. 矩阵中的幸运数        Simple
 *
 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 *
 * 幸运数是指矩阵中满足同时下列两个条件的元素：
 *
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LuckyNumbers {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++){
            int min = 0;
            for (int j = 1; j < matrix[0].length; j++){
                if (matrix[i][min] > matrix[i][j]){
                    min = j;
                }
            }
            boolean flag = true;
            System.out.println(matrix[i][min]);
            for (int j = 0; j < matrix.length; j++){
                if (matrix[j][min] > matrix[i][min]){
                    flag = false;
                    break;
                }
            }
            if (flag){
                list.add(matrix[i][min]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LuckyNumbers luckyNumbers = new LuckyNumbers();
        luckyNumbers.luckyNumbers(new int[][]{
                {3,7,8},{9,11,13},{15,16,17}
        });
    }
}
