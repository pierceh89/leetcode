package io.github.pierceh89.leetcode;

import io.github.pierceh89.leetcode.ds.Tuple;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    // BFS

    // took from https://leetcode.com/problems/rotting-oranges/discuss/515257/JavaScript-BFS-solution
    public int orangesRottingBFS(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int fresh = 0;
        int minute = 0;
        Queue<Tuple> rotten = new LinkedList<>();
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    rotten.offer(Tuple.of(i, j));
                }
            }
        }

        while (!rotten.isEmpty()) {
            int size = rotten.size();
            for (int i=0; i < size; i++) {
                Tuple t = rotten.poll();
                if(t.r-1 >=0 && grid[t.r-1][t.c] == 1) {
                    fresh--;
                    grid[t.r-1][t.c] = 2;
                    rotten.offer(Tuple.of(t.r-1, t.c));
                }
                if(t.r+1 < row && grid[t.r+1][t.c] == 1) {
                    fresh--;
                    grid[t.r+1][t.c] = 2;
                    rotten.offer(Tuple.of(t.r+1, t.c));
                }
                if(t.c-1 >=0 && grid[t.r][t.c-1] == 1) {
                    fresh--;
                    grid[t.r][t.c-1] = 2;
                    rotten.offer(Tuple.of(t.r, t.c-1));
                }
                if(t.c+1 < col && grid[t.r][t.c+1] == 1) {
                    fresh--;
                    grid[t.r][t.c+1] = 2;
                    rotten.offer(Tuple.of(t.r, t.c+1));
                }
            }
            if (rotten.size() > 0) minute++;
        }

        if (fresh == 0) return minute;
        else return -1;
    }

    // matrix iteration
    // for each iteration on grid,
    // rotten orange should rot adjacent rotten oranges
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int minute = 0;

        // if no fresh orange, return -1
        boolean foundFresh = false;
        for(int i=0; i < row; i++) {
            for(int j=0; j < col; j++) {
                if (grid[i][j] == 1) {
                    foundFresh = true;
                    break;
                }
            }
        }
        if (!foundFresh) {
            return 0;
        }
        boolean affected = false;
        do {
            affected = false;
            int[][] effectGrid = new int[row][col];
            for(int i=0; i < row; i++) {
                for(int j=0; j < col; j++) {
                    //
                    if (grid[i][j]==2) {
                        // rotten orange
                        if (i-1 >= 0 && grid[i-1][j] == 1) {
                            affected = true;
                            effectGrid[i-1][j] = 1;
                        }
                        if (i+1 < row && grid[i+1][j] == 1) {
                            affected = true;
                            effectGrid[i+1][j] = 1;
                        }
                        if (j-1 >= 0 && grid[i][j-1] == 1) {
                            affected = true;
                            effectGrid[i][j-1] = 1;
                        }
                        if (j+1 < col && grid[i][j+1] == 1) {
                            affected = true;
                            effectGrid[i][j+1] = 1;
                        }
                    } else {
                        continue;
                    }
                }
            }
            // after search, change fresh to rot
            for(int i=0; i < row; i++) {
                for(int j=0; j < col; j++) {
                    if (effectGrid[i][j] == 1) {
                        grid[i][j] = 2;
                    }
                }
            }
            if (affected) minute++;
        } while(affected);

        // if fresh orange found, return -1
        for(int i=0; i < row; i++) {
            for(int j=0; j < col; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return minute;
    }
}
