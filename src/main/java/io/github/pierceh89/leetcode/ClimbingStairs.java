package io.github.pierceh89.leetcode;

/**
 * 70. Climbing Stairs
 * Time Complexity is O(n)
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] solutions = new int[n+1];
        solutions[0] = 1;
        solutions[1] = 1;
        for(int i=2; i<n+1; i++) {
            solutions[i] = solutions[i-1] + solutions[i-2];
        }
        return solutions[n];
    }
}
