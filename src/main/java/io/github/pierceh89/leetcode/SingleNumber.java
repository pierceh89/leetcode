package io.github.pierceh89.leetcode;

import java.util.Arrays;

/**
 * 136. Single Number
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        // O(nlogn) solution due to sorting nums
        Arrays.sort(nums, 0, nums.length);
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    // to find answer in O(n), XOR should be employed
    // https://leetcode.com/problems/single-number/discuss/42997/My-O(n)-solution-using-XOR
}
