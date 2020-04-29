package io.github.pierceh89.leetcode;

/**
 * 560. Subarray Sum Equals K
 * Leetcoding Challenge Week4 Day1
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        for(int i=0; i<nums.length; i++) {
            int sum = 0;
            for(int j=i; j<nums.length; j++) {
                sum += nums[j];
                if(sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
