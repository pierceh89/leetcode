package io.github.pierceh89.leetcode;

/**
 * Time complexity is O(n)
 */
public class RemoveDuplicateFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int sz = nums.length;
        if (sz == 0) {
            return 0;
        }
        int pos = 1;
        int val = nums[0];
        int count = 1;
        for (int i=1; i < sz; i++) {
            if (val != nums[i]) {
                // modification
                count++;
                nums[pos] = nums[i];
                val = nums[pos];
                pos++;
            }
        }
        return count;
    }
}
