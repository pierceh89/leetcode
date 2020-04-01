package io.github.pierceh89.leetcode;

import java.util.Arrays;

/**
 * 581. Shortest Unsorted Continuous Array
 */
public class ShortestUnsortedContinuousArray {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length==0) {
            return 0;
        }
        int[] sorted = new int[nums.length];
        System.arraycopy(nums, 0, sorted, 0, nums.length);
        Arrays.sort(sorted);
        int i=0, j=0, count=0;
        for(int k=0; k<nums.length; k++) {
            if(nums[k] != sorted[k]) {
                if(count == 0) {
                    i=k;
                } else {
                    j=k;
                }
                count++;
            }
        }
        if(i==j) {
            return 0;
        }
        return j-i+1;
    }
}
