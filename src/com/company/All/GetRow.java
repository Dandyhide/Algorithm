package com.company.All;

import java.util.ArrayList;
import java.util.List;

public class GetRow {
    public List<Integer> getRow(int rowIndex) {
        int[][] row = new int[rowIndex + 1][rowIndex + 1];
        for (int i = 0; i <= rowIndex; i++){
            for (int j = 0; j <= i; j++){
                if (j == 0 || j == i){
                    row[i][j] = 1;
                }else{
                    row[i][j] = row[i - 1][j - 1] + row[i - 1][j];
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j <= rowIndex; j++){
            list.add(row[rowIndex][j]);
        }
        return list;
    }
}
