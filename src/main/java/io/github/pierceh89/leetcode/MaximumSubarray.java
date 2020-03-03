package io.github.pierceh89.leetcode;

/**
 * 53. Maximum Subarray
 * compute sum of sub arrays of length from 1 to n
 * Time complexity is O(n^2)
 */
class MaximumSubarray {
	    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int[] buffer = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            int subLen = nums.length-i;
            for(int j=0; j <subLen; j++) {
                if(i==0) {
                    buffer[j] = nums[j];
                }
                else {
                    buffer[j] = buffer[j]+nums[j+i];
                }
				max = Math.max(max, buffer[j]);
            }
        }
        return max;
    }
}
