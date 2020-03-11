package io.github.pierceh89.leetcode;

import java.util.List;

/**
 * 120. Triangle
 * Bottom Up DP Solution
 * Time Complexity O(k^2)  since the triangle consists of k nodes at kth level,
 * total number of integers is k(k+1)/2. We traverse all triangle integers.
 * Space Complexity O(k) where k is the number of rows
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int sz=triangle.size();
        int[] minpath = new int[sz];
        for(int k=sz-1; k>=0; k--) {
            List<Integer> row = triangle.get(k);
            for(int i=0; i<row.size(); i++) {
                if(k==sz-1) {
                    minpath[i] = row.get(i);
                } else {
                    minpath[i] = Math.min(minpath[i], minpath[i+1]) + row.get(i);
                }
            }
        }
        return minpath[0];
    }
}
