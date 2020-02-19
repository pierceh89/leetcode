package io.github.pierceh89.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // provided it is sorted array
//        1. Hash O(n) and O(n) space.
//        2. Sort and search with two points O(n) and O(1) space.
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])) {
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new RuntimeException("solution does not exist");
    }
}
