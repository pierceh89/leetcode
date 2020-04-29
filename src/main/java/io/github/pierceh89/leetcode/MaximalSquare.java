package io.github.pierceh89.leetcode;

/**
 * Leetcoding Challenge Week4 Day6
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0) {
            return 0;
        }
        int r = matrix.length, c = matrix[0].length;
        int smaller = r < c ? r : c;
        int maxArea=0;
        int[][][] dp = new int[smaller][r][c];
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(matrix[i][j]=='1') {
                    dp[0][i][j] = 1;
                    maxArea=1;
                }
            }
        }
        for(int k=1; k<smaller; k++) {
            for(int i=0; i<r-k; i++) {
                for(int j=0; j<c-k; j++) {
                    if(dp[k-1][i][j]==1 && dp[k-1][i][j+1]==1
                            && dp[k-1][i+1][j]==1 && dp[k-1][i+1][j+1]==1) {
                        dp[k][i][j]=1;
                        maxArea = (k+1)*(k+1);
                    }
                }
            }
        }

        return maxArea;
    }
}
