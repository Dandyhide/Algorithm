package com.company.Study.QueueAndStack.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    private void bfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        int code = i * n + j;
        queue.add(code);
        while (!queue.isEmpty()) {
            code = queue.poll();
            int row = code / n;
            int col = code % n;
            grid[row][col] = '0';
            if (row > 0 && grid[row - 1][col] == '1') {
                queue.add((row - 1) * n + col);
            }
            if (row < m - 1 && grid[row + 1][col] == '1') {
                queue.add((row + 1) * n + col);
            }
            if (col > 0 && grid[row][col - 1] == '1') {
                queue.add(row * n + col - 1);
            }
            if (col < n - 1 && grid[row][col + 1] == '1') {
                queue.add(row * n + col + 1);
            }
        }
    }
}
