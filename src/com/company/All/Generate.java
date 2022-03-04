package com.company.All;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        int[][] row = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++){
            for (int j = 0; j <= i; j++){
                if (j == 0 || j == i){
                    row[i][j] = 1;
                }else{
                    row[i][j] = row[i - 1][j - 1] + row[i - 1][j];
                }
            }
        }
        for (int i = 0; i < numRows; i++){
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j <= i; j++){
                curr.add(row[i][j]);
            }
            list.add(curr);
        }
        return list;
    }
}
