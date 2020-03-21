package io.github.pierceh89.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 *
 * there is a better solution
 * http://www.cs.utexas.edu/~moore/best-ideas/mjrty/
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int n : nums) {
            int c = countMap.computeIfAbsent(n, k -> 0);
            countMap.put(n, c+1);
        }
        int major=nums[0];
        int majorCount=countMap.get(major);
        for(int k : countMap.keySet()) {
            int cnt = countMap.get(k);
            if(majorCount < cnt) {
                major = k;
                majorCount = cnt;
            }
        }
        return major;
    }
}
