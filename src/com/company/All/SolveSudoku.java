package com.company.All;

import java.util.ArrayList;
import java.util.List;

public class SolveSudoku {

    boolean[][] row = new boolean[9][9];
    boolean[][] column = new boolean[9][9];
    boolean[][][] block = new boolean[3][3][9];
    List<int[]> spaces = new ArrayList<>();
    boolean valid = false;

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == '.'){
                    spaces.add(new int[]{i, j});
                }else{
                    int temp = board[i][j] - '0' - 1;
                    row[i][temp] = column[j][temp] = block[i / 3][j / 3][temp] = true;
                }
            }
        }
        dfs(board, 0);
    }

    private void dfs(char[][] board, int k) {
        if (k == spaces.size()){
            valid = true;
            return;
        }
        int[] ints = spaces.get(k);
        int ni = ints[0], nj = ints[1];
        for (int step = 0; step < 9 && !valid; step++){
            if (!row[ni][step] && !column[nj][step] && !block[ni / 3][nj / 3][step]){
                row[ni][step] = column[nj][step] = block[ni / 3][nj / 3][step] = true;
                board[ni][nj] = (char) (step + '0' + 1);
                dfs(board, k + 1);
                row[ni][step] = column[nj][step] = block[ni / 3][nj / 3][step] = false;
            }
        }
    }
}
