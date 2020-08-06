package io.github.pierceh89.leetcode.topinterviewquestions;

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/727/
 * Remove Duplicates from Sorted Array
 * use two pointers to store next position to assign unique value
 */
public class RemoveDupFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int cur = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[cur] != nums[i]) {
                cur++;
                nums[cur] = nums[i];
            }
        }
        return cur + 1;
    }
}
