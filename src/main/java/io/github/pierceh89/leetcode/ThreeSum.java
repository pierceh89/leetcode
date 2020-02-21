package io.github.pierceh89.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Similar to TwoSum problem
 * Select one(a) value and find two values(b and c) become b + c = - a
 * Time complexity is O(n^2)
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> solutions = new HashSet<>();
        for(int i=0; i < nums.length-2; i++) {
            // -nums[i] == nums[j] + nums[k]
            int value = -nums[i];
            Map<Integer, Integer> map = new HashMap<>();
            for(int j=i+1; j < nums.length; j++) {
                if (map.containsKey(value - nums[j])) {
                    // solution
                    List<Integer> sol = new ArrayList<>();
                    sol.add(-value);
                    sol.add(value-nums[j]);
                    sol.add(nums[j]);
                    Collections.sort(sol);
                    solutions.add(sol);
                } else {
                    map.put(nums[j], j); // value - index map
                }
            }
        }
        return solutions.stream().map(it -> it.stream().collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}
