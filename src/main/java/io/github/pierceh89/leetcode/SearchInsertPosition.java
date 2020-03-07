package io.github.pierceh89.leetcode;

/**
 * 35. Search Insert Position
 * Time Complexity O(n)
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        for(int i=0; i < nums.length; i++) {
            if(nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }
}
