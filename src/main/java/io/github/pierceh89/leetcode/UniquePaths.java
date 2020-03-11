package io.github.pierceh89.leetcode;

/**
 * 62. Unique Paths
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] path = new int[n+1][m+1];
        for(int j=1; j<=n; j++) {
            for(int i=1; i<=m; i++) {
                if(i==1 && j==1) {
                    path[1][1] = 1; // path count at start;
                } else {
                    path[j][i] = path[j][i-1] + path[j-1][i];
                }
            }
        }
        return path[n][m];
    }
}
