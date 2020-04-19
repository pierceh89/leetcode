package io.github.pierceh89.leetcode;

/**
 * 64. Minimum Path Sum
 * Time Complexity O(n)
 * Space Complexity O(n)
 * where n is all elements count
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] sum = new int[r][c];
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(i==0 && j==0) {
                    sum[i][j]=grid[i][j];
                } else if(i==0) {
                    sum[i][j] = sum[i][j-1] + grid[i][j];
                } else if(j==0) {
                    sum[i][j] = sum[i-1][j] + grid[i][j];
                } else {
                    int prevsum = Math.min(sum[i-1][j], sum[i][j-1]);
                    sum[i][j] = prevsum + grid[i][j];
                }
            }
        }
        return sum[r-1][c-1];
    }

    public void minPathBottomup(int[][] grid, int[][] minpath, int r, int c) {
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if (i==0 && j==0) {
                    minpath[i][j] = grid[i][j];
                    continue;
                }
                int a = i-1 >=0 ? minpath[i-1][j] : Integer.MAX_VALUE;
                int b = j-1 >=0 ? minpath[i][j-1] : Integer.MAX_VALUE;
                minpath[i][j] = Math.min(a,b) + grid[i][j];
            }
        }
    }
}
