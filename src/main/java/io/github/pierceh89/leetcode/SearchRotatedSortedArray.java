package io.github.pierceh89.leetcode;

/**
 * Search in Rotated Sorted Array
 */
public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {

        return searchRec(nums, target, 0, nums.length-1);
    }
    public int searchRec(int[] nums, int target, int s, int e) {
        if(s>e) {
            return -1;
        }
        int idx = (s+e)/2;
        if(nums[idx]==target) return idx;

        int l = searchRec(nums, target, s, idx-1);
        if(l != -1) {
            return l;
        }
        int r = searchRec(nums, target, idx+1, e);
        if (r != -1) {
            return r;
        }
        return -1;
    }
}
