package io.github.pierceh89.leetcode;

/**
 * 27. Remove Element
 * Time complexity is O(n)
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int size = nums.length;
        for(int i=0; i<size; i++) {
            if (nums[i] == val) {
                // switch
                //for(int j=nums.length-1; j > i; j--) {
                for(int j=size-1; j > i; j--) {
                    if(nums[j] != val) {
                        nums[i] = nums[j];
                        nums[j] = val;
                        break;
                    } else {
                        size--;
                        continue;
                    }
                }
                size--;
            }
        }

        return size;
    }
}
