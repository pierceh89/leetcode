package io.github.pierceh89.leetcode;

/**
 * Leetcoding Challenge Week4 Day5
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int t1len = text1.length(), t2len = text2.length();
        int[][] dp = new int[t1len][t2len];
        for(int i=0; i<t1len; i++) {
            for(int j=0; j<t2len; j++) {
                boolean equalChar = text1.charAt(i) == text2.charAt(j);
                if(i==0&&j==0) {
                    dp[i][j] = equalChar ? 1 : 0;
                } else if(i==0) {
                    dp[i][j] = equalChar ? 1 : dp[i][j-1];
                } else if(j==0) {
                    dp[i][j] = equalChar ? 1 : dp[i-1][j];
                } else {
                    if(equalChar) {
                        dp[i][j] = dp[i-1][j-1]+1;
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }
        return dp[t1len-1][t2len-1];
    }
}
