package com.company.All;

import java.util.ArrayList;
import java.util.List;

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        List<int[]> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    list.add(new int[]{i, j});
                }
            }
        }
        for (int[] ints : list) {
            int row = ints[0];
            int col = ints[1];
            for (int i = 0; i < m; i++){
                matrix[i][col] = 0;
            }
            for (int j = 0; j < n; j++){
                matrix[row][j] = 0;
            }
        }
    }
}
