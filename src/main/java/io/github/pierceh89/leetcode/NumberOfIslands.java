package io.github.pierceh89.leetcode;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid.length==0 || grid[0].length==0) {
            return 0;
        }
        int r = grid.length, c = grid[0].length;
        boolean[][] visit = new boolean[r][c];
        int cnt=0;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(grid[i][j]=='1' && !visit[i][j]) {
                    int[] pos = {i, j};
                    dfs(visit, grid, pos, r, c);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public void dfs(boolean[][] v, char[][] grid, int[] pos, int row, int col) {
        int[][] cur = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int r=pos[0],c=pos[1];
        if(v[r][c] || grid[r][c]=='0') {
            return;
        }
        v[r][c] = true;
        for(int[] delta : cur) {
            if(r+delta[0]>=0 && r+delta[0]<row && c+delta[1]>=0 && c+delta[1]<col &&
                    !v[r+delta[0]][c+delta[1]]) {
                int[] newpos = {r+delta[0], c+delta[1]};
                dfs(v, grid, newpos, row, col);
            }
        }
    }
}
