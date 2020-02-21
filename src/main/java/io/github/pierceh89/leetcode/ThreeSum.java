package io.github.pierceh89.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    // from https://github.com/haoel/leetcode/blob/master/algorithms/cpp/3Sum/3Sum.cpp
    // Time Complexity is O(n^2)
    // http://en.wikipedia.org/wiki/3SUM
    public List<List<Integer>> threeSum2(int[] nums) {
        List<Integer> numList =  Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<List<Integer>> solutions = new ArrayList<>();
        // sort array
        Collections.sort(numList);
        int n = numList.size();

        for (int i=0; i < n-2; i++) {
            if (i > 0 && numList.get(i-1).equals(numList.get(i))) continue;
            int a = numList.get(i);
            int low = i + 1;
            int high = n - 1;
            while (low < high) {
                int b = numList.get(low);
                int c = numList.get(high);
                if (a + b + c == 0) {
                    // solution
                    List<Integer> sol = new ArrayList<>();
                    sol.add(a);
                    sol.add(b);
                    sol.add(c);
                    solutions.add(sol);

                    while(low < high && numList.get(low).equals(numList.get(low+1))) low++;
                    while(low < high && numList.get(high-1).equals(numList.get(high))) high--;
                    low++;
                    high--;
                } else if (a+b+c > 0) {
                    // skip the duplication
                    while (high > 0 && numList.get(high).equals(numList.get(high-1))) high--;
                    high--;
                } else {
                    // skip the duplication
                    while (low < n -1 && numList.get(low).equals(numList.get(low+1))) low++;
                    low++;
                }
            }
        }
        return solutions;
    }
}
