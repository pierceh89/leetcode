package io.github.pierceh89.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. Find All Numbers Disappeared in an Array
 */
public class FindAllNumbersDisappearedInArray {
    /*
     * Time complexity O(n)
     * Space complexity O(n) for appear array
     */
    public List<Integer> findDisappearedNumbersExtraSpace(int[] nums) {
        int n = nums.length;
        boolean[] appear = new boolean[n+1];
        for(int value : nums) {
            appear[value] = true;
        }
        List<Integer> ret = new ArrayList<>();
        for(int i=1; i<n+1; i++) {
            if(!appear[i]) {
                ret.add(i);
            }
        }
        return ret;
    }

    // without extra space and O(n) in runtime
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++) {
            int index = Math.abs(nums[i])-1;
            if(nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        List<Integer> ret = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }
}
